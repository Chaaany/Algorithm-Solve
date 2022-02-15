package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_2407 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		BigInteger result = new BigInteger("1");
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		for (int i = 1; i <= M; i++) {
			result = result.multiply(BigInteger.valueOf(N - i + 1));
			result = result.divide(BigInteger.valueOf(i));
		}
		System.out.println(result);
	}
}
