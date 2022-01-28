package boj;

import java.util.Scanner;

public class Boj_2875 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int max = -1;
		for (int i = 0; i <= K; i++) {
			int index = (N - i) / 2 >= M - (K - i) ? M - (K - i) : (N - i) / 2;
			max = index > max ? index : max;
		}
		System.out.println(max);

	}
}
