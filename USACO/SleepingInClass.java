package USACO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SleepingInClass {
	static int T, N, arr[], total, temp[], min, target, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			total = 0;
			min = 1000001;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			temp = new int[N];
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(stz.nextToken());
				temp[j] = arr[j];
				total += arr[j];
			}
			Arrays.sort(temp);
			for (int j = 1; j <= N; j++) {
				if(total % j != 0 )continue; // 나눠서 나머지가 있는 경우 prunning
				target = total / j;// 목표 합 구하기
				if (target < temp[N - 1])
					break; // 목표합보다 값이 더 큰경우에는 고려할 필요도없이 prunning
				if (check(target, arr)) {
					min = Math.min(min, cnt);
				}
			}
			if (i != T - 1) {
				sb.append(min + "\n");
			} else {
				sb.append(min);
			}
		}
		System.out.print(sb);

	}

	private static boolean check(int target, int[] arr) {
		int i = 0;
		int sum = 0;
		cnt = 0;
		while (i < N) {
			if (sum + arr[i] < target) {
				sum += arr[i];
				i++;
				cnt++;
			} else if (sum + arr[i] == target) {
				sum = 0;
				i++;
			} else {
				return false;
			}
		}
		return true;
	}

}
