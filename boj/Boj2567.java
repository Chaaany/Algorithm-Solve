package boj;

import java.util.Scanner;

public class Boj2567 {

	static int arr[][];
	static int cnt;
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		arr = new int[102][102];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cnt = 0;
		for (int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			color(r, c);
		}
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j] == 1)
					check(i, j);
			}
		}
		System.out.println(cnt);
	}

	private static void check(int i, int j) {
		for (int a = 0; a < 4; a++) {
			int nr = i + d[a][0];
			int nc = j + d[a][1];
			if (arr[nr][nc] == 0)
				cnt++;
		}
	}

	private static void color(int r, int c) {
		for (int i = r; i < r + 10; i++) {
			for (int j = c; j < c + 10; j++) {
				arr[i][j] = 1;
			}
		}
	}
}
