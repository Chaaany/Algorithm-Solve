package boj;

import java.util.Scanner;

public class Boj_1094 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i <= 6; i++) {
			if((1 & X>>i) == 1) cnt++;
		}
		System.out.println(cnt);
	}

}
