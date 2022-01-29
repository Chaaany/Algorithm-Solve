package boj;

import java.util.Scanner;

public class Boj_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int answerN = 1;
		int answerK = 1;
		for (int i = 0; i < K; i++) {
			answerN *= (N - i);
			answerK *= (K - i);
		}
		System.out.println(answerN / answerK);
	}
}

// 이항계수 재귀로 풀기
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");
//
//
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//
//		System.out.println(BC(N, K));
//
//	}
//
//	static int BC(int n, int k) {
//
//		if(n == k || k == 0) {
//			return 1;
//		}
//
//		return BC(n - 1, k - 1) + BC(n - 1, k);
//	}
//}