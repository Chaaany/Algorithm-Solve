package boj;

import java.util.Scanner;

public class Boj_5522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		for (int i = 0; i < 5; i++) {
			answer += sc.nextInt();
		}
		
		System.out.println(answer);
	}
}
