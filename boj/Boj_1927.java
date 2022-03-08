package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1927 {
	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp == 0) {
				if (pq.peek() != null) {
					sb.append(pq.poll() + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else {
				pq.add(temp);
			}
		}
		System.out.println(sb);
	}
}
