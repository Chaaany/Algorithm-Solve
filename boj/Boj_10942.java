package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10942 {
	static int N, arr[], M, S, E;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine());
		arr = new int[N + 1]; // 0 안씀
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			S = Integer.parseInt(stz.nextToken());
			E = Integer.parseInt(stz.nextToken());
			check(S, E);
		}
		System.out.println(sb);

	}

	private static void check(int start, int end) {
		int s = start;
		int e = end;
		boolean chk = true;
		while(s < e) {
			if(arr[s] != arr[e]) {
				chk = false;
				break;
			} else {
				s++;
				e--;
			}
		}
		if(chk) {
			sb.append(1).append("\n");
		}else {
			sb.append(0).append("\n");
		}
		
	}
}
