package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {
	static int map[][][], M, N, H,
			delta[][] = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, -1, 0 } }, tomatoCnt;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");
		StringTokenizer stz;
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		H = Integer.parseInt(temp[2]);

		map = new int[H + 1][N + 1][M + 1]; // 패딩
		tomatoCnt = 0;
		q = new LinkedList<>();
		// 입력 받기
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				stz = new StringTokenizer(br.readLine());
				for (int k = 1; k <= M; k++) {
					map[i][j][k] = Integer.parseInt(stz.nextToken());
					if (map[i][j][k] == 0)
						tomatoCnt++;
					if (map[i][j][k] == 1)
						q.add(new int[] { i, j, k });

				}
			}
		}
		if (tomatoCnt == 0) { // 이미 다 익어있을 경우 0
			System.out.println(0);
		} else {
			bfs();
		}
	}

	private static void bfs() {
		int dayCnt = 0;
		int tempTomatoCnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int temp[] = q.poll();
				
				int h = temp[0];
				int n = temp[1];
				int m = temp[2];
				
				for (int j = 0; j < delta.length; j++) {
					int nh = h + delta[j][0];
					int nn = n + delta[j][1];
					int nm = m + delta[j][2];
					
					if(!check(nh, nn, nm))continue;
					
					if(map[nh][nn][nm] == -1 || map[nh][nn][nm] == 1) continue;
					
					tempTomatoCnt++;
					map[nh][nn][nm] = 1;
					q.add(new int[] { nh, nn, nm});
					
				}
				
			}
			dayCnt++;
		}
		if(tomatoCnt == tempTomatoCnt) {
			System.out.println(dayCnt-1);
		}else {
			System.out.println(-1);
		}
	}

	private static boolean check(int nh, int nn, int nm) {
		return 1 <= nh && nh <= H && 1 <= nn && nn <= N && 1 <= nm && nm <= M;
	}
}
