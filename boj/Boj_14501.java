package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_14501 {
	static int N, arr[][], dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		N = Integer.parseInt(br.readLine());
		dp = new int[1500010];
		arr = new int[N][2];
		Arrays.fill(dp, -1);
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = Integer.parseInt(stz.nextToken());
		}
		System.out.println(recur(0));
	}

	private static int recur(int cnt) {
		if (cnt > N)
			return -10000000;
		if (cnt == N)
			return 0;

		if (dp[cnt] != -1)
			return dp[cnt];
		dp[cnt] = Math.max(recur(cnt + arr[cnt][0])+ arr[cnt][1], recur(cnt + 1));
//		dp[cnt] = Math.max(dp[cnt + arr[cnt][0]] + arr[cnt][1], recur(cnt+1));
		return dp[cnt];
	}
}
