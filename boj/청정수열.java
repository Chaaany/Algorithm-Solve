package boj;

import java.util.Scanner;

public class 청정수열 {
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		long answer = 1;
		for (int i = 1; i <= N; i++) {
			answer *= i;
		}
		System.out.println(answer);
	}
}
