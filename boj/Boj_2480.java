package boj;

import java.util.Scanner;

public class Boj_2480 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A, B, C;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		if (A == B & B == C) {
			System.out.println(10000 + A * 1000);
		} else if (A == B && B != C) {
			System.out.println(1000 + A * 100);
		} else if (A != B && B == C) {
			System.out.println(1000 + B * 100);
		} else if (A == C && B != C) {
			System.out.println(1000 + A * 100);
		} else if (A != B && A != C && B != C) {
			A = Math.max(A, B);
			A = Math.max(A, C);
			System.out.println(A * 100);
		}
	}

}
