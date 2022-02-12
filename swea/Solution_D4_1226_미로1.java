package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1226_미로1 {

	static int T = 10;
	static int N = 16;
	static int[][] map;
	static int sr, sc, er, ec, cango;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			int tn = scann.nextInt();
			map = new int[N][N];
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
			// 미로 찾기 시작
			cango = 0;
			dfs(sr, sc); // dfs
//			bfs();
			System.out.println("#" + t + " " + cango);

		}
	}

	
	
	private static void dfs(int cr, int cc) {
		map[cr][cc] =-1;
		for (int d = 0; d < 4; d++) { 
			int nr = cr + dr[d];
			int nc = cc + dc[d];
			if(!check(nr, nc))continue;
			if(er==nr&& ec ==nc) {
				cango = 1;
				return;
			}
			if(map[nr][nc]==0) {
				dfs(nr,nc);
			}
		}
	}
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 상하좌우

	private static void bfs() { // bfs는 큐를 이용함, 좌표는 객체 이용
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc }); // 시작
		map[sr][sc] = -1; // 방문 했다.
		while (!q.isEmpty()) { // 방문할 지점이 있어?
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!check(nr, nc))continue;
				// 도착했냐? 도착하지 않았으면 계속 가!
				if (nr == er && nc == ec) {
					cango = 1;
					return;
				}
				//계속 가려면
				if(map[nr][nc] != -1 && map[nr][nc] != 1) { //방문 안했어
					map[nr][nc] =-1;
					q.offer(new int[] {nr,nc});
				}

			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
