package boj;
import java.math.BigInteger;
import java.util.Scanner;

public class boj_1010 {

	public static void main(String[] args) {
//		테스트 케이스 갯수 받기
		Scanner sc = new Scanner(System.in);
		int testCaseCounter = sc.nextInt();
		BigInteger[] answer = new BigInteger[testCaseCounter];
//		mCn = mPn / n!
		for(int i = 0; i < testCaseCounter; i++) {
		
			int N = sc.nextInt();
			int M = sc.nextInt();
			BigInteger mPn = BigInteger.ONE;
			BigInteger nFactorial = BigInteger.ONE;
//			mPn
			for(int j = N; j > 0; j--) {
				mPn = mPn.multiply(BigInteger.valueOf(M));
				M--;
			}
//			n!
			for(int j = N; j > 0; j--) {
				nFactorial = nFactorial.multiply(BigInteger.valueOf(j));
			}
			answer[i] = mPn.divide(nFactorial);
		}
		for (BigInteger i : answer) {
			System.out.println(i);			
		}
		
		
	}
}
