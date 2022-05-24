package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		
		int sum[][] = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sum[i][j] = sum[i][j-1] + Integer.parseInt(stz.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		// (x1, y1), (x2, y2)
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stz.nextToken()); 
			int y1 = Integer.parseInt(stz.nextToken()); 
			int x2 = Integer.parseInt(stz.nextToken()); 
			int y2 = Integer.parseInt(stz.nextToken());
			long tempSum = 0;
			for (int j = x1; j <= x2; j++) {
				tempSum += sum[j][y2] - sum[j][y1-1]; 
			}
			sb.append(tempSum).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
