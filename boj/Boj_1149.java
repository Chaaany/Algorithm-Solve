package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
	static int colorCost[][];
	static int dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 매순간 그리디하게 선택한다고 생각해본다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		colorCost = new int[N][3];
		dp = new int[N][3];
		StringTokenizer stz;
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			if (i == 0) {
				dp[i][0] = Integer.parseInt(stz.nextToken());
				dp[i][1] = Integer.parseInt(stz.nextToken());
				dp[i][2] = Integer.parseInt(stz.nextToken());
				colorCost[i][0] = dp[i][0];
				colorCost[i][1] = dp[i][1];
				colorCost[i][2] = dp[i][2];
				continue;
			}
			colorCost[i][0] = Integer.parseInt(stz.nextToken());
			colorCost[i][1] = Integer.parseInt(stz.nextToken());
			colorCost[i][2] = Integer.parseInt(stz.nextToken());
		}
		System.out.println(Math.min(findMin(N - 1, 0), Math.min(findMin(N - 1, 1), findMin(N - 1, 2))));
	}

	static int findMin(int homeN, int color) {

		if (dp[homeN][color] == 0) {
			switch (color) {
			case 0:
				dp[homeN][color] =colorCost[homeN][color] + Math.min(findMin(homeN - 1, 1), findMin(homeN - 1, 2));
				break;
			case 1:
				dp[homeN][color] = colorCost[homeN][color] +  Math.min(findMin(homeN - 1, 0), findMin(homeN - 1, 2));

				break;
			case 2:
				dp[homeN][color] = colorCost[homeN][color] + Math.min(findMin(homeN - 1, 0), findMin(homeN - 1, 1));
				break;
			}
		}

		return dp[homeN][color];

	}
}
