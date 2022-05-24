package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int sum[] = new int[N+1];
		StringBuilder sb = new StringBuilder();
		stz = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(stz.nextToken());
		}
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stz.nextToken());
			int b = Integer.parseInt(stz.nextToken());
			sb.append(sum[b]-sum[a-1]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);		
		
	}
}
