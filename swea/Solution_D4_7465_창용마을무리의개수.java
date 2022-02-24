package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {
	static int N, M, count, parent[];
	static boolean answerVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		//처리
		for (int t = 1; t <= T; t++) { //테케 만큼 포문 순회
			stz = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stz.nextToken()); // 정점 갯수
			M = Integer.parseInt(stz.nextToken()); // 간선 갯수
			parent = new int[N+1]; // 1~N번 인덱스 = 정점
			answerVisited = new boolean[N+1]; // 답 뽑아낼 배열
			count = 0;
			
			for (int i = 1; i <= N; i++) { // makeSet
				parent[i] = i; // 정점 초기화
			}
			
			for (int i = 0; i < M; i++) { // 간선 갯수로 유니온 시작
				stz = new StringTokenizer(br.readLine());
				union(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
			}
			
			for (int i = 1; i <= N; i++) { // parent 순회하면서 중복되지 않는 인덱스 구하기
				if(!answerVisited[find(i)]) {
					answerVisited[find(i)] = true;
					count++;
				}; 
			}
			sb.append("#"+ t+ " " + count+"\n");
		}
		System.out.print(sb);
		
	}
	private static void union(int x, int y) {
		if(find(x) == find(y)) return;
		
		parent[find(y)] = find(x);
	}
	
	private static int find(int x) {
		if(parent[x] == x) return parent[x];
		
		return parent[x] = find(parent[x]);
	}
}
