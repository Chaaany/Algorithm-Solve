package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj_14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int answer = 0;
		TreeSet<String> ts = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			ts.add(br.readLine().trim());
		}
		for (int i = 0; i < M; i++) {
			if(ts.contains(br.readLine().trim())) answer++;
		}
		System.out.println(answer);
	}
}
