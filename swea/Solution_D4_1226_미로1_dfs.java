package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1226_미로1_dfs {

	static int T = 10;
	static int N = 16;
	static int[][] map;
	static int cango;

	static int sr, sc, er, ec;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			map = new int[N][N];

			int n = scann.nextInt();
			for (int i = 0; i < N; i++) {
				char[] cs = scann.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = cs[j] - '0';
					if (map[i][j] == 2) {
						sr = i;
						sc = j;
					} else if (map[i][j] == 3) {
						er = i;
						ec = j;
					}
				}
			}
			// 로직
			cango = 0;
			dfs(sr, sc);

			System.out.println("#" + t + " " + cango);
		}

	}

	private static void dfs(int r, int c) {
		map[r][c] = -1;
		for (int d = 0; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			if (nr == er && nc == ec) {
				cango = 1;
				return;
			}

			if (!check(nr, nc))
				continue;
			if (map[nr][nc] == 0) {
				dfs(nr, nc);
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
