package boj;

import java.io.*;
import java.util.*;

public class Boj_2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 포도주 선택 시 다 마셔야 하고 원래 위치에 놓는다
		// 2. 연속으로 놓여있는 3잔 못마심 +1,+1 불가 ->
		// 최대로 마실 수 있는 포도주의 양은?
		// 1 <= 포도주 잔 갯수 n <= 10000, 0 <= 포도주 양 <=1000 -> 변수들 int 선언 가능
		// O
		// O O
		// X O O
		// O X O
		// O O X
		// O O X O
		// O X O O
		// O O X O O
		// O X O O X
		// X O O X O
		// O X O X O
		//
		// 점화식 도출 n번째까지의 최대로 마신양 = max(n-1번째까지 마신 최대의 양, n + (n-1번째 양 + n-3번째까지의 max), n
		// + (n-2번째까지의 max))
		// 포도주 양이 0 일 때는 들지 않기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n + 1]; // 0번째 패딩
		int dp[] = new int[n + 1];
		int answer = -1;

		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		if (n < 3) { // n이 3보다 작으면
			for (int i = 1; i <=n; i++) {
				dp[i] = dp[i-1]+wine[i];
			}
			answer = dp[n];
		} else {
			dp[1] = wine[1];
			answer = Math.max(dp[1], answer);
			dp[2] = wine[2] + wine[1];
			answer = Math.max(dp[2], answer);

			for (int i = 3; i <= n; i++) {
				if (wine[i] == 0) { // i번째 포도주의 양이 0이면 이전까지의 max포도주가 최대
					dp[i] = dp[i - 1];
					answer = Math.max(dp[i], answer);
				} else { // i번째 포도주의 양이 0이 아니면
					dp[i] = Math.max(dp[i - 1], wine[i] + Math.max(wine[i - 1] + dp[i - 3], dp[i - 2]));
					answer = Math.max(dp[i], answer);
				}
			}
		}

		System.out.println(answer);
	}
}
