package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_2_Letter_Strings {
	static int T, N, nums[];
	static long answer;
	static String words[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			answer = 0L;
			N = Integer.parseInt(br.readLine());
			words = new String[N];
			for (int j = 0; j < N; j++) {
				words[j] = br.readLine();
			}
			nums = new int[2];
			visited = new boolean[N];
			nPr(0);
			sb.append(answer/2).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	private static void nPr(int cnt) {
		if(cnt == 2) {
			check();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			
			nums[cnt] = i;
			visited[i] = true;
			nPr(cnt+1);
			visited[i] = false;
			
			
		}
	}
	private static void check() {
		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			if(words[nums[0]].charAt(i) == words[nums[1]].charAt(i))cnt++;
		}
		if(cnt == 1)answer++;
	} 
}
