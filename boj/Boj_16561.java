package boj;

import java.util.Scanner;

public class Boj_16561 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int counter = 0;
		
		for (int i = 1; i <= N/3-2; i++) {
			for (int j = 1; j <= N/3-1; j++) {
				if(N/3-i-j > 0) counter++;
			}
		}
		System.out.println(counter);
		
	}
}
