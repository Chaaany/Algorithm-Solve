package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	static int T, N, arr[][], nums[], min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 2][2];
			nums = new int[N + 2];
			stz = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				arr[i][0] = Integer.parseInt(stz.nextToken());
				arr[i][1] = Integer.parseInt(stz.nextToken());
			}
			nums[0] = 0;
			nums[N + 1] = 1;
			perm(1, new boolean[N + 2], 0);
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.print(sb);

	}

	private static void perm(int cnt, boolean v[], int tempTotal) {
		if (tempTotal >= min) return;
		
		if (cnt == N + 1) {
//			int total = sum(nums);
			min = Math.min(min, tempTotal+ getSum(cnt));
			return;
		}

		for (int i = 2; i < N + 2; i++) {
			if (v[i])
				continue;

			nums[cnt] = i;
			v[i] = true;
			perm(cnt + 1, v, tempTotal + getSum(cnt));
			v[i] = false;
		}
	}

	private static int getSum(int cnt) {
		return Math.abs(arr[nums[cnt]][0] - arr[nums[cnt - 1]][0]) + Math.abs(arr[nums[cnt]][1] - arr[nums[cnt - 1]][1]);
	}

//	private static int sum(int[] nums2) {
//		int total = 0;
//		for (int i = 1; i < N + 2; i++) {
//			total += Math.abs(arr[nums[i]][0] - arr[nums[i - 1]][0]) + Math.abs(arr[nums[i]][1] - arr[nums[i - 1]][1]);
//		}
//		return total;

//	}
}
