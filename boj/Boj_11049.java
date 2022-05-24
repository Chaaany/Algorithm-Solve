package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11049 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// a : 5 3
		// b : 3 2
		// c : 2 6
		// f(a, n) = min(f(a, c)
		// A B C
		// A[0] x A[1] x B[1] + A[0] X B[1] X C[1]
		// A[0] X B[0] x C[1] + B[0] X B[1] X C[1]

		// ABCD
		// (AB)CD -> (ABC)D -> ABCD
		// (AB)CD -> AB(CD) -> ABCD
		// A(BC)D -> (ABC)D -> ABCD
		// A(BC)D -> A(BCD) -> ABCD
		// AB(CD) -> A(BCD) -> ABCD
		// dp 배열은 2차원

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N + 1][N + 1];
		int arr[][] = new int[N + 1][2];
		StringTokenizer stz;
		for (int i = 1; i < 3; i++) {
			stz = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = Integer.parseInt(stz.nextToken());
		}

		dp[0][2] = Math.min(arr[0][0] * arr[0][1] * arr[1][1] + arr[0][0] * arr[1][1] * arr[2][1],
				arr[1][0] * arr[1][1] * arr[2][1] + arr[0][0] * arr[1][0] * arr[2][1]);

		for (int end = 3; end <= N; end++) { // 경
			for (int start = end-2; start > 0; start--) { // 출
				for (int pass = start+1; pass < end; pass) { // 도
					dp[start][end] = Math.min(dp[start][end], )
				}
			}
		}

	}
}
