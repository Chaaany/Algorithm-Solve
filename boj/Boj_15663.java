package boj;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_15663 {
	static Set<String> ts;
	static int M, N, arr[], nums[];
	static StringBuilder sb;

	public static void main(String[] args) {
		sb = new StringBuilder();
		ts = new LinkedHashSet<>();
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M];
		nums = new int[N];
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		combi(0, new boolean[M], "");
		for (String temp : ts) {
			System.out.println(temp);
		}
	}

	private static void combi(int cnt, boolean[] visited, String total) {
		if (cnt == N) {
			total.trim();
			ts.add(total);
			return;
		}

		for (int i = 0; i < M; i++) {
			if(visited[i])continue;
			visited[i] = true;
			combi(cnt + 1, visited, total+arr[i]+" ");
			visited[i] = false;
		}
	}
}
