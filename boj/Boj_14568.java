package boj;

import java.util.Scanner;

public class Boj_14568 {
	public static void main(String[] args) {
		int[] arr = new int[3];
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		for(int i = 2; i <= N; i += 2) {
			for (int j = 1; j <= N; j++) {
				if(N-i-j>=j+2) cnt++;
			}
		}
		System.out.println(cnt);
	}
}