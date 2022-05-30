package boj;

import java.io.*;
import java.util.*;

public class Boj_24445 {
	public static void main(String[] args) throws Exception {
		// 시간 제한 : 1초 => 약 1억 번 연산 가능
		// 메모리 제한 : 512MB => 정수(4바이트) 기준 256 x 1024 x 512 개 생성 가능 = 2^8 x 2^10 x 2^9 = 2^27
		// N개 정점, M개 간선 & 무향 그래프
		// 1 ~ n / 간선 가중치 1
		// 정점 R에서 시작
		// 노드 방문 순서 출력(오름차순)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		// N, M, R 순서로 입력
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int R = Integer.parseInt(stz.nextToken());
		
		List[] arr = new ArrayList[N+1];
		
		// 배열 초기화
		for(int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 그래프 입력 받기
		for(int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}
		
		//오름차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		}
		
		
		// 시작점 부터 Queue에 넣고 bfs시작
		boolean visited[] = new boolean[N+1];
		int answer[] = new int[N+1];
		int index = 1;
		answer[R] = index++;
		visited[R] = true;
		Queue<Integer> q = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		q.add(R);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				List<Integer> tempArr = arr[temp];
				
				for (int j = arr[temp].size()-1; j >= 0; j--) {
					int node = tempArr.get(j);
					// 기방문 노드
					if(visited[node]) continue;
					
					answer[node] = index++;
					q.add(node);
					visited[node] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append("\n");
		}
		sb.setLength(sb.length()-1);
		
		System.out.println(sb.toString());
		
		
	}
}
