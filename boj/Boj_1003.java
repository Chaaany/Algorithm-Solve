package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1003 {
	static int[] counter;
	static int T, N;
	static int[][] dp;
	static BufferedReader br;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			dp = new int[41][2];
			N = Integer.parseInt(br.readLine());
			for (int j = 0; j <= N; j++) {
				if (j == 0) {
					dp[j][0] = 1;
					dp[j][1] = 0;
				} else if (j == 1) {
					dp[j][0] = 0;
					dp[j][1] = 1;
				} else {
					dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
					dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
				}
			}
			sb.append(dp[N][0] + " " + dp[N][1] + "\n");
		}
		System.out.println(sb);
	}
}
