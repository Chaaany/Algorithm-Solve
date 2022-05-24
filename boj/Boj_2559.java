package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2559 {
	// 17분
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stz =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		int K = Integer.parseInt(stz.nextToken());
		int sum[] = new int[N+1];
		int answer = Integer.MIN_VALUE;
		stz = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1]+ Integer.parseInt(stz.nextToken());
		}
		
		for (int i = K; i <= N; i++) {
			answer = Math.max(answer, sum[i]-sum[i-K]);
		}
		System.out.println(answer);
	}
}
