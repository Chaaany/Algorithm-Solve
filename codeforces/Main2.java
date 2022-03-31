package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int arr[];
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pq.add(Integer.parseInt(stz.nextToken()));
			}
			int check = 0;
			if(pq.size() == 1) {
				check = pq.poll();
			}else {
				check = pq.poll()-pq.poll();
			}
			
			if(check > 1) {
				sb.append("NO").append("\n");
			}else {
				sb.append("YES").append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());

	}
}
