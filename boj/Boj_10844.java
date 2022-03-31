package boj;

import java.util.Scanner;

public class Boj_10844 {
	public static void main(String[] args) {
		// 계단 수 => 인접한 모든 자리의 차이가 1
		// n번째 수 = n-1번째 수 +1 or n-1 번째 수 -1;
		// n-1번째가 0인 경우 = dp[n-2][1];
		// dp[n][1] = dp[n-1][0] + dp[n-1][2];
		// dp[n][9] = dp[n-1][8];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[][] = new long[n+1][12]; // 0번 인덱스 = 안씀, 1번인덱스 = 0, ... 10번인덱스 = 9, 11번 인덱스 = 안씀(0 
		long answer = 0;
		for (int i = 1; i <= 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int N = 2; N <= n; N++) { 
			for (int i = 1; i <= 10; i++) {
					dp[N][i] = (dp[N - 1][i - 1]% 1000000000 + dp[N - 1][i + 1] % 1000000000) %1000000000;
				}
		}
		
		for (int i = 1; i <= 9; i++) {
			answer = (answer%1000000000 + dp[n][i]%1000000000) % 1000000000;
		}

		System.out.println(answer);
	}

}
