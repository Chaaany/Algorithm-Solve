package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_1932 {
	static int arr[][], dp[][], N, max;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = i ; j >= 0; j--) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
				if(i == N-1) {
					dp[i][j] = arr[i][j];
				}
			}
		}
		
		
		for (int i = N-2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = arr[i][j]+Math.max(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		
		System.out.println(dp[0][0]);
	}

}
