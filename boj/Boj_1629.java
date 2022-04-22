package boj;

import java.util.Scanner;

public class Boj_1629 {
	public static void main(String[] args) {
		// 11-> x * x^10 / x * x^5 * x^5
		
		Scanner sc = new Scanner(System.in);
		
		long A, B, C;
		A = sc.nextLong();
		B = sc.nextLong();
		C = sc.nextLong();
		
		long answer = power(A, B, C);
		System.out.println(answer);
		
	}

	
	// f(x)
	// x = 1일 때 x;
	// x = 0일 때 1;
	// x가 홀수 일 때 x * (x/2) *(x/2)
	// x가 짝수 일 때 (x/2)*(x/2)
	
	
	// 101 -> 1 x 50 x 50
	// 50 -> 25 x 25
	// 25 -> 1 x 12 x 12
	// 12 -> 6 x 6
	// 6 -> 3 x 3
	// 3 -> 1 x 1x 1
	// 1 -> 1
	// x / x * x / x*x*x*x / x*x*x*x*x*x*x*x
	// 7    3          1
//	
	
	private static long power(long a, long y, long p) {
		long x = a % p;
		long answer = 1L;
		while(y > 0) {
			if((y & 1) == 1) {
				answer = answer * x % p;
			}
			x = x * x % p;
			y >>= 1;
		}
		return answer;
		
	}
	
	private static long power(long a, long y, long p) {
		if(y == 0) return 1;
		
		if(y == 1) return a % p;
		
		long temp = power(a, y/2, p);
		
		if((y & 1) == 1) {
			return a % p * temp % p * temp % p % p;
		}else {
			return temp % p * temp % p % p;
		}
	}
}
