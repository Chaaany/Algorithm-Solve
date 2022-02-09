package boj;

import java.util.Scanner;

public class Boj_11051 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] nCr = new int[N+1][N+1];
		
		for(int i = 0; i < nCr.length; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == j || j == 0)
					nCr[i][j] = 1;
				else
					nCr[i][j] = (nCr[i-1][j-1] + nCr[i-1][j]) % 10007;
			}
		}
		System.out.println(nCr[N][K]);
	}
}