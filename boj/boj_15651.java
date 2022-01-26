package boj;

import java.util.Scanner;

public class Boj_15651 {
	private static int M;
	private static int N;
	private static int[] arr;
	private static StringBuilder sb;

	public static void recur(int cur) {
		if (cur == N) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= M; i++) {
			arr[cur] = i;
			recur(cur + 1);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M];

		recur(0);
		System.out.println(sb);

	}
}
