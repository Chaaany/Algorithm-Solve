package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1600 {
	static int[][] monkeyD = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static int[][] horseD = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } }; // 좌상
	static int[][] map;
	static boolean[][][] visited;
	static int answer = -1;
	static int K, W, H;

	static class Monkey {
		int r, c, cnt, jump;

		Monkey(int r, int c, int cnt, int jump) {
			this.r = r; 
			this.c = c;
			this.cnt = cnt;
			this.jump = jump;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		W = Integer.parseInt(stz.nextToken());
		H = Integer.parseInt(stz.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
			}
		}

		Queue<Monkey> q = new LinkedList<>();
		visited[0][0][0] = true;
		q.offer(new Monkey(0, 0, 0, 0));
		bfs(q, H - 1, W - 1);

		System.out.println(answer);
	}

	private static void bfs(Queue<Monkey> q, int targetR, int targetC) {

		while (!q.isEmpty()) {
			Monkey temp = q.poll();

			if (temp.r == targetR && temp.c == targetC) {
				answer = temp.cnt;
				return;
			}

			for (int i = 0; i < monkeyD.length; i++) {
				int nr = temp.r + monkeyD[i][0];
				int nc = temp.c + monkeyD[i][1];

				if (!check(nr, nc))
					continue;

				if (visited[nr][nc][temp.jump])
					continue; // 방문한 적 있니?
				visited[nr][nc][temp.jump] = true;
				q.offer(new Monkey(nr, nc, temp.cnt + 1 , temp.jump));
			}

			if (temp.jump == K)
				continue;

			for (int i = 0; i < horseD.length; i++) {
				int nr = temp.r + horseD[i][0];
				int nc = temp.c + horseD[i][1];

				if (!check(nr, nc))
					continue;
				if (visited[nr][nc][temp.jump + 1])
					continue; // 방문한 적 있니?

				visited[nr][nc][temp.jump + 1] = true;
				q.offer(new Monkey(nr, nc, temp.cnt + 1, temp.jump + 1));
			}

		}
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < H && 0 <= nc && nc < W && map[nr][nc] != 1;
	}
}
