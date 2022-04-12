package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11404 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(arr[i], 100000001);
		}
		
		for (int i = 0; i < T; i++) {
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			if(arr[from][to] > cost)arr[from][to] = cost;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)	continue;
				for (int k = 1; k <= N; k++) {
					if (k == j || k == i)continue;
					if(arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] =arr[j][i] + arr[i][k];
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(arr[i][j]== 100000001) {
					sb.append(0).append(" ");
				}else {
					sb.append(arr[i][j]).append(" ");
				}
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
