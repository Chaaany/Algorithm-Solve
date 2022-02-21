package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260 {
	static int arr[][], N, M, V;
	static StringBuilder sbDFS, sbBFS;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		V = Integer.parseInt(stz.nextToken());
		arr = new int[N+1][N+1]; // 정점 인덱스 그대로 사용(0은 미사용 인덱스)
		sbDFS = new StringBuilder();
		sbBFS = new StringBuilder();
		
		for (int i = 0; i < M; i++) { // 무향 그래프
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		dfs(V, new boolean[N+1]);
		bfs(V, new boolean[N+1]);
		System.out.println(sbDFS+"\n"+sbBFS);
	}

	private static void dfs(int start, boolean[] visited) {
		sbDFS.append(start+" ");
		visited[start] = true;
		
		for (int i = 1; i <=N ; i++) {
			if(!visited[i] && arr[start][i] != 0) {
				dfs(i, visited);
			}
		}
	}
	
	private static void bfs(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		sbBFS.append(start+" ");
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && arr[current][i] != 0) {
					visited[i] = true;
					q.offer(i);
					sbBFS.append(i+" ");
				}
			}
		}
	}
}
