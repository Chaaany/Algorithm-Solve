package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int sumModuloGroup[] = new int[M];
		stz = new StringTokenizer(br.readLine());
		int acSum = 0;
		for (int i = 1; i <= N; i++) {
			acSum += Integer.parseInt(stz.nextToken());
			acSum %= M;
			sumModuloGroup[acSum]++;
		}
		long cnt = 0;
		for (int i = 0; i < M; i++) {
			cnt += (sumModuloGroup[i]) * (sumModuloGroup[i]-1) /2;
		}
		cnt += sumModuloGroup[0];
		System.out.println(cnt);
		
	}
}
