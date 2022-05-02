package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 배열에 정수 x (x ≠ 0)를 넣는다.
		// 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를
		// 출력하고, 그 값을 배열에서 제거한다.
		// 1 <= N <= 100,000, x는 long 범위 -> long형 최소힙 선언

		PriorityQueue<Node> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			long temp = Long.parseLong(br.readLine());
			if (temp == 0) {
				if (pq.isEmpty()) {
					sb.append(temp).append("\n");
				} else {
					sb.append(pq.poll().origin).append("\n");
				}
			} else {
				pq.add(new Node(temp));
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {
		long origin;
		long absolute;

		public Node(long origin) {
			this.origin = origin;
			this.absolute = (long) Math.abs(origin);
		}

		@Override
		public int compareTo(Node o) {
			if (this.absolute == o.absolute) {
				return this.origin <= o.origin ? -1 : 1;
			}
			return this.absolute <= o.absolute ? -1 : 1;
		}

	}
}
