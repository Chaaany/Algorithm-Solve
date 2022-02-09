package swea;

import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {
	static int T;
	static int M;
	static int profit;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			M = sc.nextInt();
			arr = new int[M][M];
			profit = 0;
			String temp;
			for (int i = 0; i < M; i++) {
				temp = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = temp.charAt(j) - '0';
					profit += arr[i][j];
				}
			}
			profit -= check1();
			profit -= check2();
			profit -= check3();
			profit -= check4();

			System.out.println("#" + t + " " + profit);
		}
	}

	private static int check4() {
		int sum = 0;
		int a = 1;
		for (int i = (M / 2) + a; i < M; i++, a++) {
			for (int j = M - a; j < M; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	private static int check3() {
		int sum = 0;
		int a = 0;
		for (int i = M / 2 + 1; i < M; i++, a++) {
			for (int j = 0; j <= a; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	private static int check2() {
		int sum = 0;
		for (int i = 0; i < M / 2; i++) {
			for (int j = M / 2 + 1 + i; j < M; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	private static int check1() {
		int sum = 0;
		for (int i = 0; i < M / 2; i++) {
			for (int j = M / 2 - 1 - i; j >= 0; j--) {
				sum += arr[i][j];
			}
		}
		return sum;
	}
}
