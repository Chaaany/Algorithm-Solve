package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1717 {
	
	static int pk, N, M, a, b, parent[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		makeSet();
			
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			pk = Integer.parseInt(stz.nextToken());
			a = Integer.parseInt(stz.nextToken());
			b = Integer.parseInt(stz.nextToken());
			
			if(pk == 0) {
				union(a,b);
			}else {
				if (find(a) == find(b)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.print(sb);
	}

	private static void makeSet() {
		parent = new int[N+1];
		for (int i = 0; i < parent.length; i++) {
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
		if(x == parent[x]) return parent[x];
		
		return parent[x] = find(parent[x]);
	}
}
