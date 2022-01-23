package boj;
import java.util.Scanner;

public class boj_3034 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int max = (int)Math.sqrt(W*W + H*H);
		for (int i = 0; i < N; i++) {
			if (sc.nextInt() > max) {
				System.out.println("NE");
			} else {
				System.out.println("DA");
			}
		} 
	}
}
