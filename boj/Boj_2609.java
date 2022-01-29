package boj;

import java.util.Scanner;

public class Boj_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = 0, max = 0;
		for (int i = 1; i <= (N >= M ? M : N); i++) {
			if (N % i == 0 && M % i == 0) {
				max = i;
			}
		}

		for (int i = N * M; i > 0; i--) {
			if ( i % N == 0 && i % M == 0) {
				min = i;
			}
		}
		System.out.println(max);
		System.out.println(min);

	}
}
