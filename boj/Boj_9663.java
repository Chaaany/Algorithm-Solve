package boj;

import java.util.Scanner;

public class Boj_9663 {
	static int N, answer, nums[]; // 우하, 좌하

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		nums = new int[N];
		perm(0, new boolean[N]);
		System.out.println(answer);
	}

	private static void perm(int cnt, boolean[] visited) {
		if(cnt > 1 
				&& check(cnt))return;
		
		if (cnt == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			nums[cnt] = cnt;
			nums[cnt] = i;
			perm(cnt + 1, visited);
			visited[i] = false; // 사용 끝

		}

	}

	private static boolean check(int size) {
		int gap1 = 0;
		int gap2 = 0;

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				gap1 = Math.abs(nums[i] - nums[j]);
				gap2 = Math.abs(i-j);
				if(gap1 == gap2 ) return true;
			}
		}
		
		return false;
	}
}
