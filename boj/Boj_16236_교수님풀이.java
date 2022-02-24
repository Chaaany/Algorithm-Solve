package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_16236_교수님풀이 {
	static class Shark {
		int r;
		int c;
		int size = 2;
		int qunt;
		int time;

		public Shark(int r, int c, int size, int qunt, int time) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.qunt = qunt;
			this.time = time;
		}

		public Shark() {
		}
	}

	static class Fish1 implements Comparable<Fish1> {
		int r;
		int c;
		int size;
		int d; // 상어와의 거리 나중에 계산해서
		// 를 찾고 거리순, 위 하

		@Override
		public int compareTo(Fish1 f) {// 오름차순
			int rr = Integer.compare(this.d, f.d);
			if (rr == 0) {
				int u = Integer.compare(this.r, f.r);
				if (u == 0) {
					return Integer.compare(this.c, f.c);
				} else {
					return u;
				}
			} else {
				return rr; // 거리 1순위
			}
		}

		public Fish1(int r, int c, int size, int d) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.d = d;
		}

		public Fish1() {
		}

	}

	static int N;
	static int[][] map;
	static boolean[][] vMap;
	static Shark shark;
	static int cnt;
	static List<Fish1> fishq = new ArrayList<>();
	static PriorityQueue<Fish1> ff = new PriorityQueue<>(); // 먹을 수 있는 상어

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0, 0);
				}
			}
		}
		check();
		System.out.println(shark.time);

	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int distance = 0;

	private static void check() { // bfs
		vMap = new boolean[N][N];
		distance = -1;
		bfs(shark.r, shark.c, 0);
	}

	private static void bfs(int r, int c, int tempDistance) {
		Queue<int[]> nextQ = new LinkedList<>();
		
		while (!q.isEmpty()) {
			int[] start = q.poll();
			int r = start[0];
			int c = start[1];

			if (r == fishR && c == fishC) {
				distance = tempDistance;
				return;
			}

			for (int i = 0; i < delta.length; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				if (!check(nr, nc))
					continue; // 갈 수 있는 곳이니
				tempMap[r][c] = -1; // 방문 표시
				nextQ.offer(new int[] { nr, nc });
			}
		}

		bfs(nextQ, tempDistance + 1, fishR, fishC);
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N && (map[nr][nc] <= shark.size) && tempMap[nr][nc] != -1;
	}
}
