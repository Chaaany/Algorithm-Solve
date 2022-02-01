package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			String key = stz.nextToken();
			if (map.get(key) == null) {
				map.put(key, 1);
			}
			else {
				map.put(key, map.get(key)+1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			String key = stz.nextToken();
			int answer = map.get(key) == null ? 0 : map.get(key);
			sb.append(answer).append(" ");
		}
		System.out.println(sb);
		
		
		
	}
}
