package boj;

import java.util.Scanner;

public class Boj_11444 {
	// f(n) = f(n-1) + f(n-2)
	// f(2) = f(1) + f(0) = 1
	// f(3) = f(2) + f(1) =
	// f(3) = (f(1) + f(0)) + f(0)
	// f(4) = (f(1) + f(0)) + f(0) + (f(1) + f(0))
	// f(5) = (1 + 1) + 1
	// f(6) = (1 + 1 + 1) + (1 + 1)
	// f(7) = (1 + 1 + 1 + 1 + 1) + (1 + 1 + 1)
	// f(n) = f(n-2) + f(n-3) + f(n-2)
	// f(n) = 2*f(n-2) + f(n-3)
	// 1 1 f(n-1) f(n-2) => 피보나치
	// 1 1 f(n-2) f(n-3)
	// f(3) = 1
	// f(4) = 1 + 1 = 1*1 + 1*1
	// f(5) = 1 + 1 + 1 = 2*1 + 1*1
	// f(6) = 1 + 1 + 1 + 1 + 1 = 3 + 2
	// f(7) = (1 + 1 + 1 + 1 + 1) + (1 + 1 + 1) = 5 + 3
	// f(n) = 2*f(n-2) + f(n-3)
	// A1 1 1 A2 2 1 A3 3 2 A4 5 3 A5 8 5
	// 1 0 1   1 2 1 3 2 5 3
	static long arr[][] = { { 1L, 1L }, { 1L, 0L } };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		if (n == 1) {
			System.out.println(1);
		} else {
			System.out.println(power(n - 1, 1000000007)[0][0]%1000000007);
		}
	}

	private static long[][] power(long y, long p) {
		long[][] answer = new long[2][2];
		for (int i = 0; i < 2; i++) {
			answer[i][i] = 1L;
		}
		while (y > 0) {
			if ((y & 1) == 1) {
				answer = matrixByMatrix(answer, arr, p);
			}
			arr = matrixByMatrix(arr, arr, p);
			y >>= 1;
		}
		return answer;
	}

	private static long[][] matrixByMatrix(long[][] answer, long[][] arr2, long p) {
		long[][] temp = new long[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					temp[i][k] += (answer[i][j] * arr2[j][k]) % p;
				}
			}
		}
		return temp;
	}
}