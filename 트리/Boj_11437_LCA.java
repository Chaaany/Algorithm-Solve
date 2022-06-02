package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11437_LCA {
	static List<Integer>[] v;
	static int N, parent[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		v = new ArrayList[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			v[i] = new ArrayList<Integer>();
		}

		StringTokenizer stz;

		for (int i = 0; i < N - 1; i++) {
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());

			v[from].add(to);
			v[to].add(from);
		}

		dfs(0, 1);
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(stz.nextToken());
			int y = Integer.parseInt(stz.nextToken());
			sb.append(findRoot(x, y)).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static int findRoot(int x, int y) {
		int root = 0;
		List<Integer> X = new ArrayList<>();
		List<Integer> Y = new ArrayList<>();
		
		
		while(x != 0) {
			X.add(x);
			x = parent[x];
		}
		
		while(y != 0) {
			Y.add(y);
			y = parent[y];
		}
		
		int xIndex = X.size()-1;
		int yIndex = Y.size()-1;
		
		while(xIndex >= 0 && yIndex >= 0 && X.get(xIndex).equals(Y.get(yIndex))) {
			xIndex--;
			yIndex--;
		}
		root = X.get(xIndex+1);
		return root;
	}

	private static void dfs(int prv, int cur) {

		parent[cur] = prv;
		for (int nxt : v[cur]) {
			if(nxt == prv)continue;
			dfs(cur, nxt);
		}
		
	}
}
