package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_프림ver {


	// union find
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stz.nextToken());
			int E = Integer.parseInt(stz.nextToken());
			
			int[][] adjMatrix = new int[N+1][N+1]; // 인접행렬 리스트
			int[] minEdge = new int[N+1]; // 타 정점에서 자신으로의 간선비용중 최소비용
			boolean[] visited = new boolean[N+1]; // 신장트리에 선택된 여부
			for (int i = 0; i < E; i++) {
				stz = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(stz.nextToken());
				int to = Integer.parseInt(stz.nextToken());
				int weight = Integer.parseInt(stz.nextToken());
				adjMatrix[from][to] = weight;
				adjMatrix[to][from] = weight;
			}
			for (int i = 1; i <= N; i++) {
				minEdge[i] = Integer.MAX_VALUE; // 충분히 큰값으로 최소값 초기화
			}
			long result = 0; // MST 비용
			minEdge[1] = 0; // 자기자신은 이미 손 뻗음 
			for (int c = 1; c <= N; c++) { // N개의 정점을 모두 연결
				// 신장트리에서 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택
				int min = Integer.MAX_VALUE;
				int minVertex = 0;
				for (int i = 1; i <= N; i++) {
					if(!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				
				// 선택된 정점을 신장트리에 포함시킴
				visited[minVertex] = true;
				result += min;
				// 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고 최소값 갱신
				for (int i = 1; i <= N; i++) {
					// 아직 방문하지 않은 정점이고, 간선이 존재하고, 해당 정점 가는 비용 중에 작은 게 맞니?
					if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
						minEdge[i] = adjMatrix[minVertex][i];
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
