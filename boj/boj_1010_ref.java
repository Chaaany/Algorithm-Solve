package boj;
import java.util.Scanner;

public class boj_1010_ref {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaseCounter = sc.nextInt();
		int[] answer = new int[testCaseCounter];
		for(int i = 0; i < testCaseCounter; i++) {
			answer[i] = 1;
			int N = sc.nextInt();
			int M = sc.nextInt();
//		mCn = mPn / n!
			for(int j = 1; j <= N; j++) {
				answer[i] *= M - j + 1;
				answer[i] /= j;
			}
		}
		for (int i : answer) {
			System.out.println(i);			
		}
		
	}
}
