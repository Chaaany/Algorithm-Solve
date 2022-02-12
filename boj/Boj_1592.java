package boj;

import java.util.Scanner;


public class Boj_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt(), L = sc.nextInt(), LCD = 0;
		
//		N과 L의 최소공배수 구하기 (최악의 경우 50 x 50)
		for (int i = 1; i <= 2500; i++) {
			if(i % N == 0 && i % L == 0) { 
				LCD = i;
				break;
			}
		}
		
//		최소공배수를 L로 나누기  & (M-1) X 최소공배수를 L로 나눈 값
		System.out.println((M-1)* (LCD / L));
		
	}
}
