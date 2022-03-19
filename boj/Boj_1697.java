package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1697 {
	static int N, K, answer, delta[][] = {{2,0},{1,-1},{1,1}}, visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		visited = new int[1000000];
		N = sc.nextInt();
		K = sc.nextInt();
		Arrays.fill(visited, -1);
		bfs();
		System.out.println(visited[K]);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 0;
		int num = 0;
		int temp = N;
		while(!q.isEmpty() && temp != K) {
			temp = q.poll();
			for (int i = 0; i < 3; i++) {
				num = delta[i][0]*temp + delta[i][1];
				if(0 <= num && num <= 200000 && visited[num] == -1) {
					visited[num] = visited[temp]+1;
					q.add(num);
				}
			}
		}
	}
}
