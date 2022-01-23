package boj;
import java.util.Scanner;

public class boj_2442 {
	public static void main(String[] args) {
		//공백 = N - i 
		//별 = 2i-1		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i-1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
