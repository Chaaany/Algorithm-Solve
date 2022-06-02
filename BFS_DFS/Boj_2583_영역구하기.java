package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2583_영역구하기 {
	static int delta[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }, M, N, K, map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stz = new StringTokenizer(br.readLine());

		M = Integer.parseInt(stz.nextToken());
		N = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());

		map = new int[N][M];

		for (int i = 0; i < K; i++) {
			stz = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stz.nextToken());
			int y1 = Integer.parseInt(stz.nextToken());
			int x2 = Integer.parseInt(stz.nextToken());
			int y2 = Integer.parseInt(stz.nextToken());

			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[j][k] = 1;
				}
			}
		}

		PriorityQueue<Integer> answer = new PriorityQueue<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					continue;
				answer.add(bfs(i, j));
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();

		sb.append(cnt).append("\n");

		while (!answer.isEmpty()) {
			sb.append(answer.poll()).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static int bfs(int startR, int startC) {
		Queue<int[]> q = new LinkedList<>();
		map[startR][startC] = 1;
		q.add(new int[] { startR, startC });
		int cnt = 1;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int temp[] = q.poll();
				int r = temp[0];
				int c = temp[1];

				for (int j = 0; j < delta.length; j++) {
					int nr = r + delta[j][0];
					int nc = c + delta[j][1];

					if (!check(nr, nc))
						continue;

					map[nr][nc] = 1;
					cnt++;
					q.add(new int[] { nr, nc });
				}
			}
		}

		return cnt;

	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0;
	}
}
