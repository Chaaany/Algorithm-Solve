package boj;

import java.util.*;

public class Boj_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, m, cnt;
		for (int i = 0; i < t; i++) {
			LinkedList<int[]> queue = new LinkedList<>();
			cnt = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			for (int j = 0; j < n; j++)
				queue.add(new int[] { j, sc.nextInt() }); // 인덱스, 중요도 입력받기
			while (!queue.isEmpty()) {
				// 큐가 빌 때까지
				int[] now = queue.poll();
				boolean print = true;
				for (int[] q : queue) {
					if (q[1] > now[1])
						print = false;
				}
				if (print) {
					cnt++;
					if (now[0] == m)
						break;
				} else
					queue.add(now);
			}
			System.out.println(cnt);
		}
	}
}
