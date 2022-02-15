package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1226_미로1_bfs {

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
			bfs();

			System.out.println("#" + t + " " + cango);
		}

	}

	public static class P {
		int r, c;

		public P(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	private static void bfs() {
		Queue<P> ps = new LinkedList<>();

		ps.offer(new P(sr, sc)); // 시작
		map[sr][sc] = -1; // 지나감

		while (!ps.isEmpty()) {
			P p = ps.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + delta[d][0];
				int nc = p.c + delta[d][1];
				
				// 끝 ??
				if(nr == er && nc == ec) {
					cango = 1;
					return;
				}
				// 바깥 체크
				if (!check(nr, nc))	continue;
				// 갈수 있으면서 안간 곳
				if(map[nr][nc] == 0) {
					map[nr][nc]=-1;
					ps.offer(new P(nr,nc));  //갈 수 있는 곳 저장
				}
				
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
