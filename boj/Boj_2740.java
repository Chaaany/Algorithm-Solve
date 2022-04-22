package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2740 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int	arr[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
			}
		}

		stz = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stz.nextToken());
		int K = Integer.parseInt(stz.nextToken());
		int arr2[][] = new int[M][K];
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				arr2[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		
//		1 x 1 = 1,1 * 1*1 + 1*2 + 2*1 + 1*3 + 3*1 + 2* 3 * 3* 2
//		c11 = a11*b11 + a12*b21
//		c12 = a11*b12 + a12*b22
//		c13 = a11*b13 + a12*b23
		int answer[][] = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < K; k++) {
					answer[i][k] += arr[i][j]*arr2[j][k];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
