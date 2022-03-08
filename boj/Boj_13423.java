package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_13423 {
	static int answer;
	static HashMap<Integer, Boolean> hm;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N, arr[];
		hm = new HashMap<>();
		for (int i = 0; i < T; i++) {
			hm.clear();
			answer = 0;
			N = Integer.parseInt(br.readLine());
			stz = new StringTokenizer(br.readLine());
			arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(stz.nextToken());
				hm.put(arr[j], true);
			}
			Arrays.sort(arr);

			nCr(0, 0, new int[2], arr, N);
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}

	private static void nCr(int cnt, int next, int[] nums, int[] arr, int N) {
		if (cnt == 2) {
			if(check(nums)) answer++;
			return;
		}

		for (int i = next; i < N ; i++) {
			nums[cnt] = arr[i];
			nCr(cnt+1, i+1, nums, arr, N);
		}
	}

	private static boolean check(int[] nums) {
		int gap = nums[1] - nums[0];
		if(hm.get(nums[1]+gap) != null)
			return true;
		
		return false;
	}
}
