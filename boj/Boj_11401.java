package boj;

import java.io.IOException;
import java.util.Scanner;

public class Boj_11401 {
	static long[] fac;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n, r;
		long p = 1000000007;
		n = sc.nextInt();
		r = sc.nextInt();
		fac = new long[n+1];
		fac[0] = 1L;
		for (int i = 1; i < fac.length; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		
		System.out.println((fac[n] * power(fac[r] * fac[n-r] % p , p-2, p) % p));
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		long piv = x;
		
		while(y > 0) {
			if((y&1) == 1)res *= piv; // 홀수일 경우 그냥 곱해줌
			piv *= piv; // 제곱수 만들어버리기
			res %= p; // mod 
			piv %= p; // mod
			y >>= 1; // 나누기 
		}
		return res;
	}
}
