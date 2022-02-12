package boj;

import java.util.Scanner;

public class Boj_18870 {
	public static void main(String[] args) {
		int[] arr; 
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[1000001];
		
		for (int i = 0; i < N; i++) {
			arr[sc.nextInt()+1000000000]++;
		}
	
	}
}
