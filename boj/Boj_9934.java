package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9934 {

	static int k;
	static int N;
	static int[] arr;
	static int[] dfsArr;
	static Queue<Integer> q;
	static int cnt;
	static int[]bfsArr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		q = new LinkedList<>();
		

		k = Integer.parseInt(br.readLine());
		N = (int) (Math.pow(2, k));
		arr = new int[N]; // 노드
		dfsArr = new int[N];
		cnt = 1;
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		
		inorderDfs(1);
		bfs();
		System.out.println(sb);

	}

	private static void bfs() {
		
		for (int i = 0; i < k; i++ ) {
			for (int j = 1<<i; j < (1<<(i+1)); j++) {
				sb.append(dfsArr[j]).append(" ");
			}
			sb.append("\n");
		}
	}

	private static void inorderDfs(int i) {
		if (i * 2 <= N-1)
			inorderDfs(2*i);
		dfsArr[i] = arr[cnt++]; 
		if (i * 2 + 1 <= N-1)
			inorderDfs( 2*i +1);
		
	}
}
