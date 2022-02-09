package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Solution_D3_7234_안전기지 {
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] answer;
	static int arr[][];
	static int T, N, B;
	static BufferedReader br;
	static StringTokenizer stz;
	static StringBuilder sb;
	static int x, y;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(stz.nextToken().trim());
			B = Integer.parseInt(stz.nextToken().trim());
			arr = new int[N + 1][N + 1];
			answer = new int[N + 1][N + 1];
			max = -1;
			// 기지국 좌표 읽기
			for (int i = 0; i < B; i++) {
				stz = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(stz.nextToken().trim());
				y = Integer.parseInt(stz.nextToken().trim());
				arr[x][y]++; // 안전기지 중복 가능
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					check(i, j);
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					max = max < answer[i][j] ? answer[i][j] : max;
				}
			}

			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);

	}

	private static void check(int r, int c) {
		// 커버 표시는 -1
		if (arr[r][c] > 0) {
			while (arr[r][c]-- > 0) {
				for (int i = 0; i < 4; i++) {
					for (int j = 1; j <= 2; j++) { // 1, 2씩 늘림
						int nr = r + d[i][0] * j;
						int nc = c + d[i][1] * j;
						if (isIn(nr, nc)) {
							if (arr[nr][nc] == 0) { // 커버지역 표시가 안되어 있으면
								arr[nr][nc] = -1; // 커버지역 표시
								answer[nr][nc]++;
							} else { // 커버지역 또는 기지국이라면
								answer[nr][nc]++; // 중첩수 1추가
							}
						}
					}
				}
			}
		}
		arr[r][c] = -1; // 자기자신도 커버
	}

	private static boolean isIn(int nr, int nc) {
		return 1 <= nr && nr <= N && 1 <= nc && nc <= N;
	}

}
