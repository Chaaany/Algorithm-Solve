package swea;

import java.util.Scanner;

public class Solution_D2_2001_파리퇴치 {

	static int[][] arr;
	static int N, M, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[2*N][2*N];
			max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, check(i, j));
				}
			}

			System.out.println("#" + t + " " + max);
		}

	}

	private static int check(int i, int j) {
		int sum = 0;
		for(int a = i; a < i+M; a++) {
			for (int b = j; b < j+M; b++) {
				sum += arr[a][b]; 
			}
		}
		return sum;
	}
}
