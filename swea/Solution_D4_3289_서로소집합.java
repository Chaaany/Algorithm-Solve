package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {
	static int parent[], rank[], T, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stz.nextToken());
			M = Integer.parseInt(stz.nextToken());
			sb.append("#" + t +" ");
			parent = new int[N + 1]; // 정점 생성 ( 0 인덱스 안씀)
			rank = new int[N + 1]; // rank 저장
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
				rank[i] = 1;
			}

			for (int i = 0; i < M; i++) {
				stz = new StringTokenizer(br.readLine());

				if (stz.nextToken().equals("0")) { // 0일 때 - Union
					union(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
				} else { // 1일 때 find & check
					sb.append(find(Integer.parseInt(stz.nextToken())) == find(Integer.parseInt(stz.nextToken())) ? 1 : 0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static int find(int p) {
		if (p == parent[p])
			return parent[p];

		return parent[p] = find(parent[p]);
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py)
			return;
		if(rank[px]<rank[py]) {//rank 큰 놈이 집어넣음
			parent[px] = py;
			
		} else {
			parent[py] = px;
			if(rank[px]== rank[py]) rank[px]++;
		}
	}
	
	
}
