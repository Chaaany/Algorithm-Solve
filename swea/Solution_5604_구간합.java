package swea;

import java.util.HashMap;
import java.util.Scanner;

public class Solution_5604_구간합 {

	static int T;
	static long A, B, S;
	static HashMap<Long, Long> m = new HashMap<Long, Long>();

	public static void main(String[] args) {

		for (int i = 1; i < 17; i++) {
			long v = pow10(0L + i);
			m.put((v - 1L), h(v - 1L));
		} // 9 99 999 9999 99999 ...

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();

		for (int i = 1; i <= T; i++) {
			A = scann.nextLong();
			B = scann.nextLong();
			S = cal(B, A);
			System.out.println("#" + i + " " + S);
		}
	}

	public static long h(long n) {
		long len = len(n) + 1L;
		// f(9) 20f(9) 300f(9) 4000f(9)
		return ((45L) * (len) * (1L + n)) / (10L);
	}

	public static long cal(long B, long A) {
		if (A <= 1) {
			return f(B);
		} else if (A == B) {
			return f(B) - f(A - 1); // 버그 수정
		} else {
			return f(B) - f(A - 1);
		}
	}

	public static long g(long n) {
		if (n <= 9) {
			return e(n);
		} else {
			long v = pow10(len(n));
			return (n / v) * (n % v + 1L) + f(n % v);
		}
	}

	public static long f(long n) {
		if (m.containsKey(n)) {
			return m.get(n);
		} else if (n <= 9) {
			return e(n);
		} else {
			long v = pow10(len(n));
			m.put(n, f(n - 1L - n % v) + g(n));
			return m.get(n);
		}
	}

	public static long e(long n) {
		return n * (n + 1L) / 2L;
	}

	public static long len(long n) {
		return 0L + (n + "").length() - 1;
	}

	public static long pow10(long n) {
		return (long) Math.pow(10, n);
	}
}