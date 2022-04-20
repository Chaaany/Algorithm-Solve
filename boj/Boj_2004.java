package boj;

import java.util.*;

public class Boj_2004 {
	public static void main(String[] args) {

		// nCm에서 0의 개수
		// n!/(n-m)!*m!
		// 끝자리 0의 갯수는 10이 얼마나 있느냐 = 2*5의 갯수
		// 25P12 / 12!
		// 25! / (13! * 12!)
		// 25 24 23 22 21 20 19 18 17 16 15 14 13 / 5: 4
		// 12 11 10 9 8 7 6 5 4 3 2 1 / 5 : 2
		// 5 10 15 20 25
		// 25 -> 5 10 15 20 25 -> 5 : 6
		// 5 10 -> 5:4 / 2 ~ 12 /
		// 5 10 15 20 25 30 35 40 45
		// 1 1 1 1 2 1 1 1 1
		// 5 10 15 20 25 30 35 40 45 50 55 60 65 70 75 80 85 90 95 100 105 110 115 120
		// 125
		// 1 1 1 1 2 1 1 1 1 2 1 1 1 1 2 1 1 1 1 2 1 1 1 1 3

		Scanner sc = new Scanner(System.in);

		long n = sc.nextInt();
		long m = sc.nextInt();
		long five = cntFive(n) - cntFive(m) - cntFive(n - m);
		long two = cntTwo(n) - cntTwo(m) - cntTwo(n - m);
		if (m == 0) {
			System.out.println(0);
		} else {
			System.out.println(Math.min(five, two));
		}

	}

	private static long cntFive(long n) {
		long cntFive = 0;
		for (long i = 5; i <= n; i *= 5) {
			cntFive += n / i;
		}
		return cntFive;
	}

	private static long cntTwo(long n) {
		long cntTwo = 0;
		for (long i = 2; i <= n; i *= 2) {
			cntTwo += n / i;
		}
		return cntTwo;
	}
}
