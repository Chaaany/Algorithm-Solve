package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15829 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//		 a = 97, z =122
		int L = Integer.parseInt(br.readLine());
		String alpha = br.readLine();
		int prime = 1234567891;
		long sum = 0;
		long r = 1;
		for (int i = 0; i < L; i++) {
			sum+= ((alpha.charAt(i)-'a'+1)*r) % prime;
			r = (r*31) % prime;
		}
		System.out.println(sum%prime);
	}
}
