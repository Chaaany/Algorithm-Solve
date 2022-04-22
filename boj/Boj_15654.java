package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15654 {
	static int arr[], nums[];
	static boolean visited[];
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		visited = new boolean[N];
		arr = new int[N];
		nums = new int[M];
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		Arrays.sort(arr);
		nCr(0, M);
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	private static void nCr(int cnt, int M) {
		if(cnt == M) {
			for (int i = 0; i < nums.length; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(visited[i])continue;
			
			nums[cnt] = arr[i];
			visited[i] = true;
			nCr(cnt+1, M);
			visited[i] = false;
			
		}
	}
}
