package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562 {
	static int arr[][], curR, curC, targetR, targetC,N,
			delta[][] = { { -2, -1 }, { -1, -2 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };
	static boolean v[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 나이트는 몇 번 움직이면 이 칸으로 이동 가능 -> BFS(최소 거리) -> 방문체크 잘 해 두기
		// 테케 갯수 -> 체스판 변 길이 -> 현재 나이트의 좌표 -> 목적지 좌표 순으로 입력 받음
		// 출력 -> 최소 몇 번만에 이동할 수 있는지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			v = new boolean[N][N];
			stz = new StringTokenizer(br.readLine());
			curR = Integer.parseInt(stz.nextToken());
			curC = Integer.parseInt(stz.nextToken());

			stz = new StringTokenizer(br.readLine());
			targetR = Integer.parseInt(stz.nextToken());
			targetC = Integer.parseInt(stz.nextToken());
			
			bfs();
			sb.append(arr[targetR][targetC]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		v[curR][curC] = true; 
		q.add(new int[] {curR, curC});
		
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for (int i = 0; i < delta.length; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				
				if(!check(nr, nc))continue;
				
				if(v[nr][nc])continue;
				
				arr[nr][nc] = arr[r][c] + 1;
				
				if(nr == targetR && nc == targetC)return;
				v[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}
}
