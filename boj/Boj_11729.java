package boj;

import java.util.Scanner;

public class Boj_11729 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sb.append((int)Math.pow(2, K)-1+"\n");
		hanoi(K, 1, 2, 3);
		System.out.println(sb);
	}

	private static void hanoi(int K, int from, int sub, int to) {
		if(K ==0) {
			return;
		}
		
		// 큰 원반 제외한 나머지 원판 시작 -> subtarget
		hanoi(K-1, from, to, sub);
		// 큰 원반 -> target
		sb.append(from+" "+ to+"\n");
		// 나머지 원판 -> target
		hanoi(K-1, sub, from, to);
	}
	
}
