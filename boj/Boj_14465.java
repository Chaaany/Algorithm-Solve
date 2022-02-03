package boj;

import java.util.Scanner;


public class Boj_14465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int B = sc.nextInt();
		int bcnt = 0;
		boolean[] arr = new boolean[N + 1];
		for (int i = 0; i < B; i++) {
			arr[sc.nextInt()] = true;
		}
		for (int i = 1; i <= K; i++) {
			bcnt = arr[i] == true? bcnt+1 : bcnt; 
		}
		int temp = bcnt;
		int a = 1;
		int b = K+1;
		int min = bcnt;
		while(b!=N+1) {
			temp = arr[a++] == true ? temp-1 : temp;
			temp = arr[b++] == true ? temp+1 : temp;
			min = min <= temp ? min : temp;
		}
		System.out.println(min);
		
		
	}

}
