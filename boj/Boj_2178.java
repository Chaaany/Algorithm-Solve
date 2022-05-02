package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {

	static int arr[][], delta[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }, answer[][];
	
	public static void main(String[] args) throws IOException {
		StringTokenizer stz;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		arr = new int[N + 2][M + 2];
		answer = new int[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(temp[j-1]);
			}
		}

		bfs(N, M);
		System.out.println(answer[N][M]+1);

	}

	private static void bfs(int n, int m) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 1, 1 });

		while (!q.isEmpty()) {
			int temp[] = q.poll();
			
			int r = temp[0];
			int c = temp[1];
			for (int i = 0; i < delta.length; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				
				if(arr[nr][nc] != 1)continue;
				
				arr[nr][nc] = 0;
				answer[nr][nc] = answer[r][c] + 1;
				if(nr == n && nc == m) return;
					
				q.add(new int[] {nr, nc});
				
				
			}
		}

	}
}
