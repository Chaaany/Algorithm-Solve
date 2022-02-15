package boj;

import java.util.Scanner;

public class Boj_2839 {

	static int N, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();

		min = Integer.MAX_VALUE;
		int t = 0;
		int f = 0;

		for (int i = 0; i <= N / 5; i++) {
			if ((N - i * 5) % 3 == 0) {
				min = Math.min(min,  i+(N-i*5)/3);
			}
		}

//		sugamove(N, 0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

//	private static void sugamove(int weight, int t, int f) {
//		if (weight < 0) { // 가능한 푸르닝 prunning
//			return;
//		}
//		if (weight == 0) { // base conmdition
//			min = Math.min(min, t + f);
//			return;
//		}
//
//		sugamove(weight - 5, t + 1, f);
//		sugamove(weight - 3, t, f + 1);
//
//	}
}
