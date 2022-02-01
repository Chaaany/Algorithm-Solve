package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Boj_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			q.offer(i + 1);
		}
		while (q.size() != 1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());

	}
}
