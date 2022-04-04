package boj;

import java.io.*;
import java.util.*;

public class Boj_4485 {
	static int N, arr[][], cost[][], answer;
	static int delta[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(true) {
			index++;
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			arr = new int[N][N];
			cost = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			}
			for (int j = 0; j < N; j++) {
				stz = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					arr[j][k] = Integer.parseInt(stz.nextToken());
				}
			}
			cost[0][0] = arr[0][0];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {0,0});
			
			bfs(q);
//			System.out.println(index +"번째 배열");
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(cost[i][j]+" ");
//				}
//				System.out.println();
//			}
			sb.append("Problem ").append(index).append(": ").append(cost[N-1][N-1]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void bfs(Queue<int[]> q) {
//		Queue<int[]> nextQ= new LinkedList<>();

		while (!q.isEmpty()) {
			int temp[] = q.poll();
			int r = temp[0];
			int c = temp[1];
			for (int i = 0; i < 4; i++
					) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				if (!check(nr, nc))
					continue;// 범위 밖 체크

				int tempCost = cost[r][c] + arr[nr][nc];

				if (tempCost < cost[nr][nc]) {
					q.add(new int[] { nr, nc });
					cost[nr][nc] = tempCost;
				}
			}
		}

	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}
}
