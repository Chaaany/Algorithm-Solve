package boj;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1504 {
	static class Node implements Comparable<Node> {
		int num;
		int distance;

		public Node(int num, int distance) {
			super();
			this.num = num;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}

	}

	static int N, E, dist[], v[][], first, second;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {

		// 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000)
		// 다익스트라 세번 1, v1, v2에서 각각 돌린 후 1->v1 + v1-> v2 + v2 -> N / 1-> v2 + v2 -> f1 +
		// v1-> N 더한 거에서 최솟값 구하고 한 곳이라도 방문 못한다면 -1출력
		// 최적화된 다익스트라

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		E = Integer.parseInt(stz.nextToken());

		v = new int[N + 1][N + 1];
		pq = new PriorityQueue<>();

		// 간선 정보 받기
		for (int i = 0; i < E; i++) {
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			int weight = Integer.parseInt(stz.nextToken());
			v[from][to] = weight;
			v[to][from] = weight;
		}
		stz = new StringTokenizer(br.readLine());
		first = Integer.parseInt(stz.nextToken());
		second = Integer.parseInt(stz.nextToken());

		int dist1[] = dijkstra(1);
		int dist2[] = dijkstra(first);
		int dist3[] = dijkstra(second);
		int preAnswer1 = dist1[first] == 900000 || dist2[second] == 900000 || dist3[N] == 900000 ? -1: dist1[first] + dist2[second] + dist3[N];
		int preAnswer2 = dist1[second] == 900000 || dist3[first] == 900000 || dist2[N] == 900000 ? -1 : dist1[second] + dist2[N] + dist3[first];
		if (preAnswer1 != -1 && preAnswer2 != -1) {
			System.out.println((int) Math.min(preAnswer1, preAnswer2));
		} else if (preAnswer1 == -1 && preAnswer2 == -1) {
			System.out.println(-1);
		} else {
			System.out.println((int) Math.max(preAnswer1, preAnswer2));
		}

	}

	private static int[] dijkstra(int j) {
		int dist[] = new int[N + 1];

		for (int i = 1; i < dist.length; i++) {
			if (i == j) {
				dist[i] = 0;
				pq.offer(new Node(i, dist[i]));
			} else {
				dist[i] = 900000;
				pq.offer(new Node(i, dist[i]));
			}
		}

		while (!pq.isEmpty()) {// pq 다 사라질 때 까지 고르기
			// 1. 가장 작은 distance 노드 고르기
			Node temp = pq.poll();
			int cur = temp.num;
			int distance = temp.distance;
			if (dist[cur] != distance)
				continue;
			// 3. 해당 노드에서 간선 다 돌면서 최솟값 갱신
			for (int i = 1; i < v[cur].length; i++) {
				if(v[cur][i] == 0 )continue;
				int tempdist = v[cur][i] + dist[cur];
				if (tempdist < dist[i]) {
					dist[i] = tempdist;
					pq.offer(new Node(i, dist[i]));
				}
			}
		}

		return dist;
	}

}
