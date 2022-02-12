package boj;

import java.util.Scanner;

public class Boj_8320 {
	
	public static void main(String[] args) {
//		3분 30초 clear
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 100; j++) {
				if(j*j > i) break;
				
				if(i%j == 0) {
					cnt++;
				}
			}
			
		}
		System.out.println(cnt);
	}
}
