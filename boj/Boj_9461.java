package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		long	dp[] = new long[101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T, N;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		for (int i = 9; i <= 100; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}

		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
		
	}
}
