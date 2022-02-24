package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753_PQ {
	
	static class Vertex implements Comparable<Vertex>{
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); 
		int E = Integer.parseInt(st.nextToken());  
		int start = Integer.parseInt(br.readLine());
		
		List[] adjList = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			adjList[i] = new ArrayList<Vertex>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken()); 
			int weight = Integer.parseInt(st.nextToken()); 
			
			adjList[from].add(new Vertex(to, weight)); 
		}
		
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Vertex> PQ = new PriorityQueue<>(); 
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		PQ.offer(new Vertex(start, distance[start]));
		
		while(!PQ.isEmpty()) {
			Vertex current = PQ.poll();
			
			if (visited[current.no]) continue;
			
			visited[current.no] = true;
			
			
			for (int j = 0; j < adjList[current.no].size(); j++) {
				Vertex temp = (Vertex)adjList[current.no].get(j);
				if (!visited[temp.no] && distance[temp.no] > distance[current.no] + temp.distance) {
					distance[temp.no] = distance[current.no] + temp.distance;
					PQ.offer(new Vertex(temp.no, distance[temp.no]));
				}
			}
		}
		
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

}