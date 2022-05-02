package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Boj_12852 {
	static TreeMap<Integer, String> tm;
	static int n, answer;

	public static void main(String[] args) {
//		1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
//		2. X가 2로 나누어 떨어지면, 2로 나눈다.
//		3. 1을 뺀다.
		// 정답 횟수 및 도출 과정 누적적으로 쌓아두고 출력

		Scanner sc = new Scanner(System.in);

		int test = 1;
//		while (test++ <= 1000) {
		n = sc.nextInt();
//		n = test;
		tm = new TreeMap<>();
		for (int i = 1; i <= n; i++) {
			tm.put(i, "");
		}
		List<Integer> tmL = new ArrayList<>();
		tmL.add(n);
		tm.put(n, n + "");
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		if (n == 1) {
			System.out.print(0 + "\n" + 1);
		} else {
			bfs(q, 1);

			System.out.println(answer + "\n" + tm.get(1).trim());
		}

	}

	private static void bfs(Queue<Integer> q, int index) {
		Queue<Integer> nextQ = new LinkedList<Integer>();
		while (!q.isEmpty()) {
			int temp = q.poll();

			if (temp % 3 == 0 && tm.get(temp / 3).length() == 0) {
//				System.out.println(index + ": 1번째");
				nextQ.add(temp / 3);
				tm.put(temp / 3, tm.get(temp) + " " + temp / 3);
				if (temp / 3 == 1) {
					answer = index;
					return;
				}
			}

			if (temp % 2 == 0 && tm.get(temp / 2).length() == 0) {
//				System.out.println(index + ": 2번째");
				nextQ.add(temp / 2);
				tm.put(temp / 2, tm.get(temp) + " " + temp / 2);
				if (temp / 2 == 1) {
					answer = index;
					return;
				}
			}

			if (temp - 1 > 0 && tm.get(temp - 1).length() == 0) {
//				System.out.println(index + ": 3번째");
				nextQ.add(temp - 1);

				tm.put(temp - 1, tm.get(temp) + " " + (temp - 1));
				if (temp - 1 == 1) {
					answer = index;
					return;
				}
			}
		}
		bfs(nextQ, index + 1);
	}
}
