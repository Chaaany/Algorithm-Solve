package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {
	static int N, M, aliveCnt, map[][], delta[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		Queue<int[]> q = new LinkedList<>(); // bfs용 큐
		stz = new StringTokenizer(br.readLine());

		M = Integer.parseInt(stz.nextToken());
		N = Integer.parseInt(stz.nextToken());
		map = new int[N + 2][M + 2];
		for (int i = 0; i <= N + 1; i++) { // 상자 초기화
			Arrays.fill(map[i], -1);
		}

		for (int i = 1; i <= N; i++) { // 상자에 정보 입력
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				if (map[i][j] == 0)
					aliveCnt++;
				if (map[i][j] == 1)
					q.offer(new int[] { i, j });
			}
		}

		fin: for (int i = 1; i <= N; i++) { // 모든 토마토 익을 수 있나 확인
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0 && check(i, j)) { // 애초에 토마토 못익음.
					cnt = -1;
					break fin;
				}
			}
		}

		if (cnt == -1 || aliveCnt == 0) { // 예외 처리 끝
			System.out.println(cnt);
		} else { // 시작!
			if (!q.isEmpty())
				bfs(q);
			if(aliveCnt == 0) {
			System.out.println(cnt);
			}else {
				System.out.println(-1);
			}
		}
	}

	private static void bfs(Queue<int[]> q) {
		
		cnt++;
		Queue<int[]> nextQ = new LinkedList<>();

		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int[] d : delta) {
				int nr = current[0] + d[0];
				int nc = current[1] + d[1];
				if (map[nr][nc] != 0)
					continue;
				aliveCnt--;
				map[nr][nc] = 1;
				nextQ.offer(new int[] { nr, nc });
			}
		}
		if (aliveCnt == 0 || nextQ.isEmpty())
			return;
		 
		bfs(nextQ);
	}

	private static boolean check(int r, int c) {
		int cnt = 0;

		for (int[] d : delta) {
			int nr = r + d[0];
			int nc = c + d[1];
			cnt = map[nr][nc] == -1 ? cnt + 1 : cnt;
		}
		if (cnt == 4) {
			return true;
		} else {
			return false;
		}
	}
}
