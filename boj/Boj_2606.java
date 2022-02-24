package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2606 {

	static int a, b, arr[][], cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		arr = new int[a+1][a+1];
		
		for (int i = 0; i < b; i++) {
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
					
			arr[from][to] = 1;
			arr[to][from] = 1;
			}
		
		dfs(1, new boolean[a+1]);
		
		System.out.println(cnt-1);
		
	}

	private static void dfs(int start, boolean[] visited) {
		if(visited[start]) return;
		visited[start] = true;
		cnt++;
		for (int i = 1; i <= a; i++) {
			if(arr[start][i] == 1) dfs(i, visited);
		}
	}
}