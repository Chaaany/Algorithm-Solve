package boj;

import java.util.Scanner;

public class Boj_6603 {
	static int[] numbers, input;
	static int K;
	static boolean[] isSelected;
	static StringBuilder sb; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while((K=sc.nextInt()) != 0 ) {
			sb = new StringBuilder();
			numbers = new int[6];
			input = new int[K];
//			isSelected = new boolean[K];
			for (int i = 0; i < K; i++) {
				input[i] = sc.nextInt();
			}
			nPr(0, 0);
			System.out.println(sb);
		}
			
	}
	
	public static void nPr(int cnt, int start) {
		if(cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < input.length; i++) {
//			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
//			isSelected[i] = true;
			nPr(cnt+1, i+1);
//			isSelected[i] = false;
		}
	}
}
