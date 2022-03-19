package boj;

import java.util.Scanner;

public class Boj_11047 {
	static int arr[], N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int answer = 0;
		
		for (int i = N-1; i >= 0; i--) {
			answer += K / arr[i];
			K %= arr[i];
		}
		
		System.out.println(answer);
		
		
	}
}
