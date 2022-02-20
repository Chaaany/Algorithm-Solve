package jg;

import java.util.Scanner;

public class jg_1523_별삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		if (n > 100 || m > 3 || m < 1) {
			System.out.println("INPUT ERROR!");
		} else {
			switch (m) {
			case 1:
				star1(n);
				break;
			case 2:

				star2(n);
				break;
			case 3:
				star3(n);
				break;
			}
		}
	}

	private static void star1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void star2(int n) {
		for (int i = n; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void star3(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j > 0; j--) {
				System.out.print(" ");
			}

			for (int j = 0; j < i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
