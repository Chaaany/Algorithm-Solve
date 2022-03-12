package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012 {
	static int T, M, N, K, answer, arr[][], delta[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		
		for (int i = 0; i < T; i++) { // 테케 만큼 순회
			answer = 0; // 답 초기화
			stz = new StringTokenizer(br.readLine());
			M = Integer.parseInt(stz.nextToken());//가로
			N = Integer.parseInt(stz.nextToken());//세로
			K = Integer.parseInt(stz.nextToken());//배추 심은 수
			
			arr = new int[N][M]; // 밭
			
			for (int j = 0; j < K; j++) {
				stz = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(stz.nextToken());
				int r = Integer.parseInt(stz.nextToken());
				arr[r][c] = 1;
			}
		
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(arr[j][k] == 1) {
						bfs(j,k);
						answer++;
					}
				}
			}
			
			sb.append(answer+"\n");
			
		}
		System.out.println(sb);
		
	
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for (int[] d : delta) {
				int nr = temp[0] + d[0];
				int nc = temp[1] + d[1];
				
				if(!check(nr, nc)) continue; // 범위 초과, 배추 있음
				
				arr[nr][nc] = 0;
				q.add(new int[] {nr, nc});
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return 0<= r && r < N && 0<= c && c < M && arr[r][c] == 1;
	}
}
