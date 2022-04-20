package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합 {
	static long[] fac;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =	Integer.parseInt(br.readLine());
		int n, r;
		long p = 1234567891;
		fac = new long[1000001];
		fac[0] = 1L;
		for (int i = 1; i < fac.length; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stz.nextToken());
			r = Integer.parseInt(stz.nextToken());
			
			
			sb.append("#").append(t).append(" ").append(nCr(n, r, p)).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static long nCr(int n, int r, long p) {
		if(r == 0)return 1L;
		
		return (fac[n] * power(fac[r], p-2, p) % p * power(fac[n-r], p-2, p) %  p ) % p;		
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		while(y > 0) {
			if(y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
		x = (x*x) %p;
		}
		return res;
	}
}
