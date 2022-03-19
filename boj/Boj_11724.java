package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11724 {
	static int N, M, parent[], answer;
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		parent = new int[N+1];
		check = new boolean[N+1];
		answer = 0;
		makeSet();
		
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			union(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
		}
		
		for (int i = 1; i <= N; i++) {
			if(!check[find(i)]) {
				answer++;
				check[find(i)] = true;
			}
		}
		
		System.out.println(answer);
		
	}
	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		parent[y] = x;
	}
	
	private static int find(int x) {
		if(x == parent[x])return parent[x];
		
		return parent[x] = find(parent[x]);
	}
}
