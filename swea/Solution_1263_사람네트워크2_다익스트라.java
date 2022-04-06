package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2_다익스트라 {

	static class Vertex implements Comparable<Vertex> {
		int no, distance;

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.distance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.distance - o.distance;
		}
	}

	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stz.nextToken());
			int[] answerArr = new int[N];
			int arr[][] = new int[N][N];
			int answer = 1000000;
			List[] adjList = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<Vertex>();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
					if (arr[i][j] != 0) {
						int from = i;
						int to = j;
						int weight = arr[i][j];
						adjList[from].add(new Vertex(to, weight));
					}
				}
			}

			for (int start = 0; start < N; start++) {
				int[] distance = new int[N];
				boolean[] visited = new boolean[N];
				PriorityQueue<Vertex> PQ = new PriorityQueue<>();

				Arrays.fill(distance, Integer.MAX_VALUE);
				distance[start] = 0;
				PQ.offer(new Vertex(start, distance[start]));

				while (!PQ.isEmpty()) {
					Vertex current = PQ.poll();

					if (current.distance != distance[current.no])continue;

					visited[current.no] = true;

					for (int j = 0; j < adjList[current.no].size(); j++) {
						Vertex temp = (Vertex) adjList[current.no].get(j);
						if (!visited[temp.no] && distance[temp.no] > distance[current.no] + temp.distance) {
							distance[temp.no] = distance[current.no] + temp.distance;
							PQ.offer(new Vertex(temp.no, distance[temp.no]));
						}
					}
				}

				for (int i = 0; i < distance.length; i++) {
					if (distance[i] == Integer.MAX_VALUE) {
						sb.append("INF\n");
					} else {
						answerArr[start] += distance[i];
					}
				}
				answer = Math.min(answer, answerArr[start]);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
	}
}