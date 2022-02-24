package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16236_풀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		Fish shark = null;
		List<Fish> ff = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(temp[j]) == 9) {
					shark = new Fish(i, j, 2, 0, 0);
					map[i][j] = 0;
					continue;
				}
				if (Integer.parseInt(temp[j]) == 1) {
					ff.add(new Fish(i, j, 0, 0, 0));
				}
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		
		if (ff.isEmpty()) {
			System.out.println(0);
			return;
		}
		PriorityQueue<Fish> pq = new PriorityQueue<Fish>(new Comparator<Fish>() {
		
			@Override
			public int compare(Fish a, Fish b) {
				if (a.distance == b.distance) {
					if (a.r == b.r) {
						return a.c - b.c;
					} else {
						return a.r - b.r;
					}
				} else {
					return a.distance - b.distance;
				}
			}
		});
		Queue<Fish> queue = new LinkedList<>();
		queue.offer(shark);
		while (true) {
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			boolean[][] chkMap = new boolean[N][N];
			chkMap[queue.peek().r][queue.peek().c] = true;
			while (!queue.isEmpty()) {
				Fish fish = queue.poll();
				int currentR = fish.r;
				int currentC = fish.c;
				for (int i = 0; i < 4; i++) {
					int nr = currentR + dr[i];
					int nc = currentC + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > fish.size || chkMap[nr][nc]) {
						continue;
					}
					if (map[nr][nc] < fish.size && map[nr][nc] != 0) {
						pq.offer(new Fish(nr, nc, fish.size, fish.eatCnt + 1, fish.distance + 1));
					}
					queue.offer(new Fish(nr, nc, fish.size, fish.eatCnt, fish.distance + 1));
					chkMap[nr][nc] = true;
				}
			}
			if (pq.isEmpty()) {
				System.out.println(result);
				return;
			}
			Fish fish = pq.poll();
			if (fish.size == fish.eatCnt) {
				fish.size++;
				fish.eatCnt = 0;
			}
			map[fish.r][fish.c] = 0;
			result += fish.distance;
			queue.offer(new Fish(fish.r, fish.c, fish.size, fish.eatCnt, 0));
			pq.clear();
		}
	}

	static class Fish {
		int r; 
		int c; 
		int size;
		int eatCnt; 
		int distance; 

		public Fish(int row, int col, int size, int eatCnt, int distance) {
			this.r = row;
			this.c = col;
			this.size = size;
			this.eatCnt = eatCnt;
			this.distance = distance;
		}
	}
}
