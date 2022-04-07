package swea;

import java.util.*;
import java.io.*;

public class Solution_1249_보급로 {
	static int T, N, arr[][], dp[][], delta[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], 1000);
				String[] temp = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(temp[j]);
				}
			}
			dp[0][0] = 0;
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { 0, 0 });
			bfs(q);
			sb.append("#").append(t).append(" ").append(dp[N - 1][N - 1]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void bfs(Queue<int[]> q) {

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];

				if (!check(nr, nc))
					continue;
				if (dp[nr][nc] > arr[r][c] + dp[r][c]) {
					dp[nr][nc] = arr[r][c] + dp[r][c];
					q.add(new int[] { nr, nc });
				}
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}
}
