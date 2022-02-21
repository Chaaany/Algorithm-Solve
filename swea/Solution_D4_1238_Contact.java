package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact {
	static int N, M, arr[][], temparr[][], lastIndex, rIndex = 0, cIndex = 0;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			stz = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stz.nextToken());
			M = Integer.parseInt(stz.nextToken());
			arr = new int[101][101];
			stz = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(stz.nextToken());
				int to = Integer.parseInt(stz.nextToken());
				lastIndex = Math.max(lastIndex, Math.max(from, to)); // 최고 노드 인덱스 번호
				arr[from][to] = 1;
			}
			temparr = new int[lastIndex+1][lastIndex+1];
			Queue<Integer> q = new LinkedList<>();
			q.offer(M);
			bfs(q, new boolean[101]);
		}
		System.out.print(sb);

	}

	private static void bfs(Queue<Integer> q, boolean[] visited) {
		int max = -1;
		if (q.size() == 0) {
			rIndex--;
			for (int i = 0; i < temparr[rIndex].length; i++) {
				max = Math.max(max, temparr[rIndex-1][i]);
			}
			sb.append(max+"\n");
			return;
		}

		Queue<Integer> nextQ = new LinkedList<>();

		while (q.size() > 0) {

			int current = q.poll();
			visited[current] = true;

			for (int i = 1; i < lastIndex; i++) {
				if (!visited[i] && arr[current][i] != 0) {
					nextQ.offer(i);
					visited[i] = true;
					temparr[rIndex][cIndex++] = i; // 답 예비후보 저장용
				}
			}
		}
		cIndex = 0;
		rIndex++;
		bfs(nextQ, visited);

	}
}
