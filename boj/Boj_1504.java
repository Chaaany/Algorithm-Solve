package boj;

import java.util.PriorityQueue;

public class Boj_1504 {
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
		
	}
	public static void main(String[] args) {
		
		// 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000)
		// 다익스트라 세번 1 -> V1 -> v2 -> N or 1 -> v2 -> v1 > N
		// 최적화된 다익스트라
		// 매번 가장 작은 
		
		
		
		
	}
}
