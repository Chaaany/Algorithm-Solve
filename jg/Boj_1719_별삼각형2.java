package jg;

import java.util.Scanner;

public class Boj_1719_별삼각형2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		if (n > 100 || n % 2 != 1 || m > 4 || m < 1) {
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
			case 4:
				star4(n);
				break;
			}
		}
	}

	private static void star1(int n) {
		for (int i = 0; i < n / 2 + 1; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = n / 2; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void star2(int n) {
		for (int i = 1; i <= n / 2 + 1; i++) {
			for (int j = n / 2 - i + 1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= n / 2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = n / 2 - i + 1; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void star3(int n) {
		for (int i = 1; i <= n / 2; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			for (int j = n - 2 * (i - 1); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= n / 2 + 1; i++) {
			for (int j = n / 2 -i +1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void star4(int n) {
		for (int i = 1; i <= n / 2; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = n / 2 + 1 - i + 1; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= n / 2 + 1; i++) {

			for (int j = 0; j < n/2; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}