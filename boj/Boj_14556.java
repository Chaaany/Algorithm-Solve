package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_14556 {
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		perm(0, 0, arr, new int[N], N);
		
		System.out.println(count);
	}

	private static void perm(int cnt, int flag, int[] arr, int[] nums, int N) {
		if(cnt == N) {
			subset(0, nums, 0, 0, N);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if((flag & 1<<i) != 0)continue;
			
			nums[cnt] = arr[i];
			perm(cnt+1, flag|1<<i, arr, nums, N);
			
		}
	}

	private static void subset(int cnt, int[] nums, int left, int right, int N) {
		if(left > right) return;
		
		if(cnt == N) {
			count++;
			return;
		}
		
		subset(cnt+1, nums, left + nums[cnt], right, N);
		subset(cnt+1, nums, left, right + nums[cnt], N);
	}
}
