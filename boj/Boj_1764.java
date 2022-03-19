package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj_1764 {
	public static void main(String[] args) throws IOException {
		int N, M, cnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		TreeMap<String, Integer> tm = new TreeMap<>();
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		String temp;
		for (int i = 0; i < N; i++) {
			tm.put(br.readLine(), 1);
		}
		for (int i = 0; i < M; i++) {
			temp = br.readLine();
			if (tm.get(temp) != null) {
				tm.put(temp, 2);
				cnt++;
			} else {
				tm.put(temp, 1);
			}
		}
		int index = 0;
		String answer[] = new String[cnt];

		for (String key : tm.keySet()) {
			if (tm.get(key) == 2) {
				answer[index++] = key;
			}
		}
		Arrays.sort(answer);
		for (int i = 0; i < index; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.print(cnt+"\n"+sb);

	}
}
