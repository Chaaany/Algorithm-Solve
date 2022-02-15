package boj;

import java.util.Scanner;

public class Boj_2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B, C;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
//		if ((A * 60 + B + C) / 60 < 24) {
//			System.out.println((A * 60 + B + C) / 60 + " " + (A * 60 + B + C) % 60);
//		} else {
//			System.out.println((A * 60 + B + C) / 60  - 24 + " " + (A * 60 + B + C) % 60);
//		}
		System.out.println(((A * 60 + B + C) / 60) % 24 + " " + (A * 60 + B + C) % 60);

	}
}
