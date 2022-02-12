package boj;

import java.util.Scanner;

public class Boj_14232 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long K = sc.nextLong();
		long tempK = K;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		// 소수판정
		for (long i = 2; i < K+1; i++) {
			if (i * i > K)
				break;

			while (K % i == 0) {
				cnt++;
				sb.append(i + " ");
				K /= i;
			}

		}
		if (cnt == 0) {
			System.out.print(2 + "\n" + 1 + " " + K);
		} else {
			if(K != 1) {
			sb.append(K);
			System.out.println(cnt + 1);
			System.out.print(sb);
			} else {
				System.out.println(cnt);
				System.out.println(sb);
			}
		}
	}
}
