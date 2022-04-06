package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182 {
	static int arr[], S, answer, nums[], N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		S = Integer.parseInt(stz.nextToken());
		arr = new int[N];
//		nums = new int[N];
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
//		for (int i = 1; i <= N; i++) {
//			nums = new int[i];
//			combi(0, 0, i, new boolean[N], 0 );
//		}
		subSet(0, 0);

		System.out.println(answer);
	}

	private static void subSet(int cnt, int total) {
		if (cnt >= N)
			return;

		int temp = total + arr[cnt];
		if (temp == S) {
			answer++;
		}

		subSet(cnt + 1, temp);
		subSet(cnt + 1, total);

	}

//	private static void combi(int start, int cnt, int N, boolean[] visited, int total) {
//		if (cnt == N) {
////			for (int i = 0; i < nums.length; i++) {
////				System.out.print(nums[i] + " ");
////			}
////			System.out.println("일 때 " + total);
//			answer = total == S ? answer + 1 : answer;
//			return;
//		}
//
//		for (int i = start; i < arr.length; i++) {
////			if(visited[i])continue;
////			
////			visited[i] = true;
//			nums[cnt] = arr[i];
//			combi(i + 1, cnt + 1, N, visited, total + arr[i]);
////			visited[i] = false;
//		}
//	}
}
