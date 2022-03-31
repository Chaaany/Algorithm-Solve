package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_크루스칼ver {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}

	// union find
	static int N;
	static int[] parents;
	static Edge[] edgeList;

	public static void makeSet() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stz.nextToken());
			int E = Integer.parseInt(stz.nextToken());
			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				stz = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(stz.nextToken());
				int to = Integer.parseInt(stz.nextToken());
				int weight = Integer.parseInt(stz.nextToken());
				edgeList[i] = new Edge(from, to, weight);
//				System.out.println(i +"번째" + edgeList[i].toString());
			}

			Arrays.sort(edgeList); // 간선 비용 오름차순
			makeSet();

			long result = 0;
			int cnt = 0;

			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					if (++cnt == N - 1)
						break;
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
