package boj;

import java.util.Scanner;

public class Boj_15652 {
	private static int cur;
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] index;
	private static StringBuilder sb = new StringBuilder();;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		recur(0, 1);
		System.out.println(sb);
	}

	private static void recur(int cur, int index) {
		if (cur == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = index; i <= N; i++) {
			arr[cur] = i;
			recur(cur + 1, i);
			index++;
		}
	}
}
