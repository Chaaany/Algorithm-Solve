package boj;

import java.util.*;
import java.io.*;


public class Boj_2636 {
		static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
		static int n, m, arr[][], lastIndex;
		static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// 가장 자리부터 채운다
		// 0 ... n 순으로 플러드 필을 한다.
		// 0 또는 이전 n의 주변에 있는 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		arr = new int[n][m];
		sb = new StringBuilder();
		// 맨처음 치즈가 있는 칸은 -1로 받는다
		// 플러드필을 0부터 n으로 차근차근 쌓아나가면서 이전에 플러드필한 수 or 0 일 경우 ++한 플러드필을 한다.
		// 가로 세로 100이므로 10,000의 수를 입력 받아야 하므로 BufferedReader와 stringtokenizer 사용
		for (int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
				if(arr[i][j] == 1) arr[i][j] = -1;
			}
		}
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {0, 0}); // 가장자리 넣기
		arr[0][0] = -2;
		bfs(q, 1, 0);
		
		System.out.println(sb);
		
		
	}

	private static void bfs(Queue<int[]> q, int floodFillIndex, int prevCount) {
		Queue<int[]> nextQ = new LinkedList<>();
		int curCount = 0;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0]; 
			int c = temp[1]; 
			for (int i = 0; i < 4; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				if(!(0 <= nr && nr < n && 0 <= nc && nc < m)) continue; // 경계 밖이니?
				
				if(arr[nr][nc] == 0) { // 공기니? -> 맨 처음 공기는 -2 처리했으니 해당 공기는 내부 공기다.
					arr[nr][nc] = -2;  // 내부 공기 일 경우면 -2로 만들고 돌기
					q.add(new int[]{nr, nc});
				}
				
				if(arr[nr][nc] == -1) { // 안 녹은 치즈니?
					nextQ.add(new int[] {nr, nc});
					arr[nr][nc] = floodFillIndex;
					curCount++;
				}
			}
		}
		if(curCount == 0 ) { // 이제 더 이상 녹일 치즈가 없을 때
			sb.append(floodFillIndex-1).append("\n").append(prevCount);
			return;
		}else { // 녹일 치즈가 있을 때
			bfs(nextQ, floodFillIndex+1, curCount); 
		}
	}
}

