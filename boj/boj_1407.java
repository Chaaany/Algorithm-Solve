package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1407 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long x = 1;
		ArrayList<Long> counterA = new ArrayList();
		ArrayList<Long> counterB = new ArrayList();
		long sumA = 0;
		long sumB = 0;
		//		1 ~ A까지의 거듭제곱 합

		if(A == 1) {
			sumA = 0;
		} else if (A == 2){
			sumA = 1;
		} else {
			A--;
			for (int i = 0; x <= A; x*=2) {
				counterA.add((A / x));
				i++;
			}
			x /= 2;
			sumA = x * counterA.get(counterA.size()-1);
			x /= 2;
			for (int i = counterA.size()-1;1 < i; i--) {
				sumA += (counterA.get(i-1) - counterA.get(i)) * x;
				x /= 2;
			}

			sumA += counterA.get(0) - counterA.get(1);
			x = 1;
		}

		if (B == 1) {
			sumB = 1;
		} else {
			for (int i = 0; x <= B; x*=2) {
				counterB.add((B / x));
				i++;
			}
			x /= 2;
			sumB = x * counterB.get(counterB.size()-1);
			x /= 2;
			for (int i = counterB.size()-1;1 < i; i--) {
				sumB += (counterB.get(i-1) - counterB.get(i)) * x;
				x /= 2;
			}

			sumB += counterB.get(0) - counterB.get(1);
			x = 1;
		}
		System.out.println(sumB-sumA);
	}
}