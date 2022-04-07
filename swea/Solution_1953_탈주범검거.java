package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static boolean visited[][];
	static int T, arr[][], N, M, thiefLoc[], time, answer;
	static int delta[][][] = { { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }, // 상, 하, 좌, 우
			{ { -1, 0 }, { 1, 0 } }, // 상, 하
			{ { 0, -1 }, { 0, 1 } }, // 좌, 우
			{ { -1, 0 }, { 0, 1 } }, // 상, 우
			{ { 1, 0 }, { 0, 1 } }, // 하, 우
			{ { 0, -1 }, { 1, 0 } }, // 좌, 하
			{ { 0, -1 }, { -1, 0 } } // 좌, 상
	};
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stz.nextToken());
			M = Integer.parseInt(stz.nextToken());
			thiefLoc = new int[2];
			thiefLoc[0] = Integer.parseInt(stz.nextToken());
			thiefLoc[1] = Integer.parseInt(stz.nextToken());
			time = Integer.parseInt(stz.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
				}
			}
			Queue<int[]> q = new LinkedList<>();
			visited[thiefLoc[0]][thiefLoc[1]] = true;
			q.add(thiefLoc);
			answer = 1;
			bfs(q, 1);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if(visited[i][j]) {
//						System.out.print("O ");
//					}else {
//						System.out.print("X ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println();
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void bfs(Queue<int[]> q, int cnt) {
		if(cnt == time) return;
		Queue<int[]> nextQ = new LinkedList<>();
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			int holeNum = arr[r][c] - 1;
			for (int i = 0; i < delta[holeNum].length; i++) {
				int nr = r + delta[holeNum][i][0];
				int nc = c + delta[holeNum][i][1];
				if (!check(nr, nc))continue;
				
				if(visited[nr][nc] || arr[nr][nc] == 0) continue;
				
				if(!crosscheck(r, c, nr, nc, arr[nr][nc])) continue;
				
				answer++;
				visited[nr][nc] = true;
				nextQ.add(new int[] {nr, nc});
			}
		}
		bfs(nextQ, cnt+1);

	}

	private static boolean crosscheck(int r, int c, int nr, int nc, int holeNum) {
		for (int i = 0; i < delta[holeNum-1].length; i++) {
			int nnr = nr + delta[holeNum-1][i][0];
			int nnc = nc + delta[holeNum-1][i][1];
			if(r == nnr && c == nnc) return true;		
		}
		return false;
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}
}
