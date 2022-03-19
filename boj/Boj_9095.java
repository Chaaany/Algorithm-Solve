package boj;

import java.util.Scanner;

public class Boj_9095 {
	
	static int T, arr[], answer[], index;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		arr = new int[T];
		answer = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}
		index = 0;
		for (; index < T; index++) {
			subset(0, arr[index], 0);
			System.out.println(answer[index]);
		}
		
	}
	private static void subset(int cnt, int target, int total ) {
		if(target == total) {
			answer[index]++;
			return;
		}
		
		if(cnt == target) {
			return;
		}
		
		subset(cnt+1, target, total+1);
		subset(cnt+1, target, total+2);
		subset(cnt+1, target, total+3);
		
	}
}
