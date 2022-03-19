package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> stringDic = new HashMap<>();
		String[] str;
		StringTokenizer stz;
		stz = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		str = new String[N+1];
		String temp;
		for (int i = 1; i <= N; i++) {
			temp = br.readLine();
			stringDic.put(temp, i);
			str[i] = temp;
		}
		
		for (int i = 0; i < M; i++) {
			temp = br.readLine();
			if(stringDic.get(temp) == null) {
				sb.append(str[Integer.parseInt(temp)]).append("\n");
			} else {
				sb.append(stringDic.get(temp)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
