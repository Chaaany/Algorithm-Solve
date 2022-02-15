package boj;

import java.util.Scanner;

public class Boj_3040 {
	
	static int person[], numbers[], answer[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		person = new int[9];
		numbers = new int[7];
		answer = new int[7];
		for (int i = 0; i < 9; i++) {
			person[i] = sc.nextInt();
		}
		
		nCr(0, 0);
		
		for (int height : answer) {
			System.out.println(height);
		}
		
	}

	private static void nCr(int cnt, int start) {
		if(cnt == 7) {
			int total = 0;
			for (int i = 0; i < numbers.length; i++) {
				total+= numbers[i];
			}
			if(total == 100) {
				for (int i = 0; i < numbers.length; i++) {
					answer[i] = numbers[i]; 
				}
				return;
			}
				
			return;
		}
		
		for (int i = start; i < person.length; i++) {
			
			numbers[cnt] = person[i];
			nCr(cnt+1, i+1);
			
		}
	}
}
