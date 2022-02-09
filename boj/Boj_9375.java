package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_9375 {
	static HashMap<String, Integer> hm;
	static BufferedReader br;
	static StringTokenizer stz;
	static StringBuilder sb;
	static int T, categoryCnt;
	static int total;

	public static void main(String[] args) throws IOException {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		hm = new HashMap<>();
		stz = new StringTokenizer(br.readLine());
		T = Integer.parseInt(stz.nextToken());
		sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			stz = new StringTokenizer(br.readLine());
			categoryCnt = Integer.parseInt(stz.nextToken());
			// 의상/카테고리 받아들이기
			for (int i = 0; i < categoryCnt; i++) {
				String[] temp = br.readLine().split(" ");
				hm.put(temp[1], hm.getOrDefault(temp[1], 0) + 1);
			}
			total = 1; // 경우의 수
			System.out.println(total);
			for (int counter : hm.values()) {
				total *= (counter + 1);
			}
			System.out.println(total - 1);
		}
	}
}
