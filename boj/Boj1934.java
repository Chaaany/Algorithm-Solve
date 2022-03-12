package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1934 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		int a, b;
		for (int i = 0; i < T; i++) {
			stz = new StringTokenizer(br.readLine());
			a = Integer.parseInt(stz.nextToken());
			b = Integer.parseInt(stz.nextToken());
			sb.append(a * b / gcd(a,b)+"\n");
		}
		
		System.out.print(sb);
	}

	private static int gcd(int a, int b) {
		int r = 0;
		while(b != 0 ) {
			r = a % b;
			
			a = b;
			b = r;
		}
		return a;
	}
}
