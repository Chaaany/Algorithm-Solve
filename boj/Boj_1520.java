package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1520 {
	static int M, N, arr[][], delta[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }, dp[][];

	public static void main(String[] args) throws IOException {
		StringTokenizer stz;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		stz = new StringTokenizer(br.readLine());

		M = Integer.parseInt(stz.nextToken());
		N = Integer.parseInt(stz.nextToken());
		arr = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
			}
		}

		bfs(0, 0);
		System.out.println(dp[M - 1][N - 1]);
	}

	private static void bfs(int startR, int startC) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return arr[o2[0]][o2[1]] - arr[o1[0]][o1[1]];
			}
		});
		
		dp[0][0] = 1;
		q.add(new int[] { startR, startC });
		
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int temp[] = q.poll();
				int r = temp[0];
				int c = temp[1];
				if (r == M - 1 && c == N - 1)
					continue;
				for (int j = 0; j < delta.length; j++) {
					int nr = r + delta[j][0];
					int nc = c + delta[j][1];

					if (!check(nr, nc))	continue;
					if (arr[r][c] > arr[nr][nc]) {

						if(dp[nr][nc] == 0)	q.add(new int[] { nr, nc });
						dp[nr][nc] += dp[r][c];
					}
				}

			}
		}

	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < M && 0 <= nc && nc < N;
	}
}
