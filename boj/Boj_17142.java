package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17142 {
	static int N, M, map[][], tempMap[][], virus[][], nums[], index,
			delta[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, targetCnt = 0, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;

		stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		map = new int[N][N];
		index = 0;
		virus = new int[N * N][2];
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				if (map[i][j] == 2) {
					virus[index][0] = i;
					virus[index++][1] = j;
				} else if (map[i][j] == 0)
					targetCnt++;
			}
		}
		nums = new int[M];
		targetCnt+=(index-M);
		nCr(0, 0);
		if (targetCnt == 0) {
			System.out.println(0);
		} else if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void nCr(int cnt, int start) {

		if (cnt == M) {
			bfs();
			return;
		}

		for (int i = start; i < index; i++) {
			nums[cnt] = i;
			nCr(cnt + 1, i + 1);
		}
		
	}

	private static void bfs() {

		tempMap = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(tempMap[i], -1);
		}
//		for (int i = 0; i < index; i++) {
//			tempMap[virus[i][0]][virus[i][1]] = 0;
//		}

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			q.add(new int[] { virus[nums[i]][0], virus[nums[i]][1] });
			tempMap[virus[nums[i]][0]][virus[nums[i]][1]] = 0;
		}

		int r, c, temp[], nr, nc, tempCnt = 0;
		int tempMax = -1;
		while (!q.isEmpty()) {
			temp = q.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				nr = r + delta[i][0];
				nc = c + delta[i][1];
				if (!check(nr, nc))
					continue;
					q.add(new int[] { nr, nc });
					tempCnt++;
					tempMap[nr][nc] = tempMap[r][c] + 1;
					tempMax = Math.max(tempMap[nr][nc], tempMax);
			}
		}

		if (tempCnt != targetCnt) {
			return;
		} else {
			min = Math.min(min, tempMax);
		}

	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N && (map[nr][nc] == 0 || map[nr][nc] == 2)
				&& tempMap[nr][nc] == -1;
	}
}