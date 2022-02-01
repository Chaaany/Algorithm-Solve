package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			map.put(stz.nextToken(), 1);

		}
		int M = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			String key = stz.nextToken();
			int answer = map.get(key) == null ? 0 : 1;
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
		
		
	}
}
