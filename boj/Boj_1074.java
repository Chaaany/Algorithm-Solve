package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_1074 {
	static int N, r, c, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		cnt = 0;
		z(0, 0, 1 << N);

	}

	private static void z(int rr, int cc, int w) {
		if (rr == r && cc == c) {
			System.out.println(cnt);
			return;
		}

		// 범위 내
		if (r >= rr && r < rr + w && c >= cc && c < cc + w) {
			int hw = w / 2;
			z(rr, cc, hw); // 1
			z(rr, cc+hw, hw); // 2
			z(rr+hw, cc, hw); // 3 
			z(rr+hw, cc+hw, hw); // 4
		} else {
			cnt += w * w;
		}
	}
}
