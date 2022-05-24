package boj;

import java.util.Scanner;

public class 두부두부 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = {-2, -1, 0, +1, +2};
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int moveCnt = (K-3 % N);
		//  1 2 3 4 5 6 
		//  O         
		int answer = (M+moveCnt)%N < 0 ? N+(M+moveCnt)%N : (M+moveCnt)%N;
		if (answer == 0) {
			System.out.print(N);
		}else {
			System.out.print(answer);
		}
		
	}
	
}
