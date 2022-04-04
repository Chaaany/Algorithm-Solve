package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1<= 수열 길이 K <= 1,000, 1<= 원소의 크기 <= 2^31-1 -> int 배열 가능
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N + 1];
			int dp[] = new int[N + 1];
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[j] = Integer.parseInt(stz.nextToken());
				dp[j] = 1; // 자기 자신으로 1개의 수열 만들 수 있음 초기화
			}

			int max = 1; // 자기 자신으로 만들 때 1만큼 만들 수 있음
			// 자기 자신보다 낮은 인덱스 돌면서 탐색
			for (int j = 1; j <= N; j++) {
				for (int k = j - 1; k > 0; k--) {
					if (arr[j] > arr[k]) {
						dp[j] = Math.max(dp[k] + 1, dp[j]);
						max = Math.max(dp[j], max);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
