package boj;

import java.io.*;
import java.util.*;

public class Boj_11066 {
	public static void main(String[] args) throws Exception {
		// 1. 두 개의 파일을 합칠 때 필요한 비용 = 두 파일 크기의 합
		// 2. 최종파일 만드는 데 합치는 횟수 = 총 파일 -1
		// 3. 서로 인접한 파일들끼리만 합칠 수 있음
		//		40 30 30 50 => 40 60 50 => 100 50 => 
		//		40 30 30 50 => 70 30 50 => 70 80
		//		40 30 30 50 => 40 30 80 => 70 80
		//
		//
		//		40 60 50 60 60 100 150
		//
		//		70 30 50 = 
		//		40 30 80 = 80 70 150
		//
		//		C1 + C2 / C1 + C2 + C3   / C1 + C2 + C3 + C4 = 3*C1 + 3*C2 + 2*C3 + C4 = 9 / 3 3 2 1
		//		C1 + C2 / C3 + C4          / C1 + C2 + C3 + C4 = 2*(C1 + C2 + C3 + C4) = 8 = 2 2 2 2 
		//		C2 + C3 / C1 + C2 + C3   / C1 + C2 + C3 + C4 = 2*C1 + 3*C2 + 3*C3 + C4 = 9 / 2 3 3 1
		//		C2 + C3 /  C2 + C3 + C4  / C1 + C2 + C3 + C4 = C1 + 3*C2 + 3*C3 + 2*C4 = 9 / 1 3 3 2
		//		C3 + C4 / C2 + C3 + C4   / C1 + C2 + C3 + C4 = C1 + 2*C2 + 3*C3 + 3*C4 = 9 / 1 2 3 3 
		// 4. 분할정복느낌이 물씬 풍김
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n+1];
			int sum[] = new int[n+1];
			int dp[][] = new int[n+1][n+1]; // 0 번째와 
			
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) { // 배열 값과 합계값 미리 넣어 두기
				arr[j] = Integer.parseInt(stz.nextToken());
				sum[j] = sum[j-1] + arr[j];
			}
			
			for (int end = 2; end <= n; end++) { // 도착
				for (int start = end-1; start > 0; start--) { // 출발
					dp[start][end] = Integer.MAX_VALUE; // dp배열 초기화
					for (int pass = start; pass < end; pass++) { // 경유
						dp[start][end] = Math.min(dp[start][end], dp[start][pass] + dp[pass+1][end]+ sum[end]-sum[start-1]);
					}
				}
			}
			sb.append(dp[1][n]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
