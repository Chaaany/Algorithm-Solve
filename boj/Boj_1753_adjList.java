package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753_adjList {

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 방향 그래프가 주어짐
		// 첫째줄 정점 개수 V, 간선 개수 E
		int V = Integer.parseInt(stz.nextToken());
		int E = Integer.parseInt(stz.nextToken());

		// 둘째줄 시작 정점
		int start = Integer.parseInt(br.readLine());

		// 셋째줄부터 간선 ~ E

		Node[] adjList = new Node[V + 1];
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			stz = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			int weight = Integer.parseInt(stz.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}

		Arrays.fill(distance, Integer.MAX_VALUE); // distance 초기화
		distance[start] = 0;
		
		int min = 0, current = start;
		
		for (int i = 1; i <= V; i++) {
			// 출발지에서 가까운 정점 선택
			min = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j; 
				}
			}
			visited[current] = true;
			// 그다음 : 출발지에서 가까운 current 정점을 경유지로 하여 갈 수 있는 다른 방문하지 않은 정점들 처리
			for (Node temp = adjList[current]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (i == start) {
				sb.append(0).append("\n");
			} else if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}
		System.out.print(sb);
	}
}