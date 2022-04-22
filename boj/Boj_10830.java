package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10830 {
		static int answer[][];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		
		stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		long B = Long.parseLong(stz.nextToken());
		
		int arr[][] = new int[N][N];
		answer = new int[N][N];
		
		for (int i = 0; i < arr.length; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		for (int i = 0; i < arr.length; i++) {
			answer[i][i] = 1;
		}
		
		power(arr, B, 1000);
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(answer[i][j]%1000).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
		

	}
	private static void power(int[][] arr, long y, int p) {
		int x[][] = new int[arr.length][arr.length];
		
		for (int j = 0; j < x.length; j++) {
			x[j] = Arrays.copyOf(arr[j], arr[j].length);
		}
		
		while(y > 0) {
			if((y & 1) == 1) {
				// 홀수면 바로 이전 행렬 곱해버리기
				answer = matrixBymatix(answer, x);
			}
			
			x = matrixBymatix(x, x);
			y >>= 1;
		}
	}
	
	private static int[][] matrixBymatix(int[][] a, int[][] b){
		int ret[][] = new int[a.length][a.length];
		
		for (int i = 0; i < ret.length; i++) {
			for (int j = 0; j < ret.length; j++) {
				for (int k = 0; k < ret.length; k++) {
					ret[i][k] += (a[i][j]%1000*b[j][k]%1000)%1000;
				}
			}
		}
		
		return ret;
	}
	
}
