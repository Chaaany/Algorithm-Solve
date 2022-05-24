package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_24480 {
	static int N, M, R, answer[], cnt;
	static List<List<Integer>> arr;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		R = Integer.parseInt(stz.nextToken());
		visited = new boolean[N+1];
		answer = new int[N+1];
		cnt = 1;
		arr = new ArrayList<>();
		for (int i = 0; i <= N ; i++) { // 정점 초기화 
			arr.add(new ArrayList<>()); // 정점에 리스트 넣기
		}
		
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			
			arr.get(from).add(to);
			arr.get(to).add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(arr.get(i), new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});
		}
		answer[R] = cnt++;
		visited[R] = true;
		
		dfs(R);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
		
		
		
		
		
		
	}
	private static void dfs(int node) {
		
		List<Integer> temp = arr.get(node);
		int size = temp.size();
		for (int i = 0; i < size; i++) {
			int nextNode = temp.get(i);
			if(visited[nextNode]) continue;
			answer[nextNode] = cnt++;
			visited[nextNode] = true;
			dfs(nextNode);
		}
	}
}
