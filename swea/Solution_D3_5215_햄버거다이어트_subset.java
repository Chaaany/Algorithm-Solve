package swea;

import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트_subset {
	static int T, N, L;
	static int[] num;
	static int[] cal;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			num = new int[N];
			cal = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			max = -1;
			subset(0, 0, 0);
			System.out.println("#" + t + " " + max);
		}

	}

	private static void subset(int cnt, int sum, int val) {
		if (cnt == N) {
			// 칼로리는 <= , 맛 맥스
			if(sum <= L) {
				max = Math.max(max, val);
			}
			return;
		}
		subset(cnt+1, sum+cal[cnt], val+num[cnt]);
		subset(cnt+1, sum, val);
		
		
		
	}
}
