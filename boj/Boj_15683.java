package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15683 {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상, 우, 하, 좌
	static int arr[][], total, min;
	static List<int[]> list = new ArrayList<>();
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());

		R = Integer.parseInt(stz.nextToken());
		C = Integer.parseInt(stz.nextToken());
		min = Integer.MAX_VALUE;
		arr = new int[R][C];
		
		total = R * C; // 감시 가능한 곳 갯수
		int wallCnt = 0;
		for (int i = 0; i < R; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 6)
					list.add(new int[] { i, j, arr[i][j] }); // CCTV 위치 및 종류 확인
				if (arr[i][j] == 6)
					wallCnt++; // 벽을 제외한 감시 가능한 영역 갯수

			}

		}
		if (list.isEmpty()) {
			System.out.println(R * C - wallCnt);
		} else {
			dfs(0, arr);
			System.out.println(min);
		}
	}

	private static void dfs(int cnt, int[][] tempArr) {
		if (cnt == list.size()) { // 더이상 감시카메라 없으면
			int tempCnt = 0;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (tempArr[i][j] == 0)
						tempCnt++;
				}
			}

			min = Math.min(min, tempCnt); // 사각지대 최소 갯수;
			return;
		}
		int[][] map = new int[R][];

		// 감시카메라 있으면 ㄱㄱ
		int[] temp = list.get(cnt); // n번째 감시카메라

		switch (temp[2]) {
		case 1:
			// 현재 배열 복사
			for (int i = 0; i < 4; i++) { // 4가지 경우의 수 (상, 우, 하, 좌)
				for (int a = 0; a < R; a++) {
					map[a] = Arrays.copyOf(tempArr[a], C);
				}

				cctv(temp[0], temp[1], i, map);
				dfs(cnt + 1, map);
			}
			break;

		case 2:
			for (int i = 0; i < 2; i++) { // 2가지 경우의 수 (상,하 / 좌, 우)
				for (int a = 0; a < R; a++) {
					map[a] = Arrays.copyOf(tempArr[a], C);
				}
				cctv(temp[0], temp[1], i, map);
				cctv(temp[0], temp[1], i + 2, map);

				dfs(cnt + 1,map);
			}
			break;

		case 3:
			for (int i = 0; i < 4; i++) { // 4가지 경우의 수 (상, 우 / 우, 하 / 좌,하/ 상,좌)
				for (int a = 0; a < R; a++) {
					map[a] = Arrays.copyOf(tempArr[a], C);
				}
				cctv(temp[0], temp[1], i, map);
				cctv(temp[0], temp[1], (i + 1) % 4, map);

				dfs(cnt + 1, map);
			}
			break;

		case 4:
			for (int i = 0; i < 4; i++) { // 4가지 경우의 수 ( 상, 우, 하 / 우, 하, 좌 / 하 , 좌, 상 / 좌, 상, 우)
				for (int a = 0; a < R; a++) {
					map[a] = Arrays.copyOf(tempArr[a], C);
				}
				cctv(temp[0], temp[1], i, map);
				cctv(temp[0], temp[1], (i + 1) % 4, map);
				cctv(temp[0], temp[1], (i + 2) % 4, map);

				dfs(cnt + 1,map);
			}
			break;

		case 5:
			for (int a = 0; a < R; a++) {
				map[a] = Arrays.copyOf(tempArr[a], C);
			}
			// 1가지 경우의 수

			cctv(temp[0], temp[1], 0, map);
			cctv(temp[0], temp[1], 1, map);
			cctv(temp[0], temp[1], 2, map);
			cctv(temp[0], temp[1], 3, map);

			dfs(cnt + 1, map);
			break;
		}

	}

	private static void cctv(int r, int c, int i, int[][] tempArr) {
		if(tempArr[r][c] == 0)tempArr[r][c] = -1; // 감시완료!

		int nr = r + delta[i][0];
		int nc = c + delta[i][1];

		if (!isOutOfBoundary(nr, nc))
			return; // 경계 밖이니

		if (arr[nr][nc] == 6) {
			return; // 벽이니
		}
		
		cctv(nr, nc, i, tempArr);

	}

	private static boolean isOutOfBoundary(int nr, int nc) {
		return 0 <= nr && nr < R && 0 <= nc && nc < C;
	}

}
