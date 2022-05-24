package kakao;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
	public static int solution(int[] queue1, int[] queue2) {
		int answer = -1;
		long sumV = 0;
		long sumV1 = 0;
		long sumV2 = 0;
		int max = 0;
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		for (int i = 0; i < queue1.length; i++) {
			q1.add(queue1[i]);
			q2.add(queue2[i]);
			max = Math.max(max, queue1[i]);
			max = Math.max(max, queue2[i]);

			sumV1 += queue1[i];
			sumV2 += queue2[i];
		}
		sumV = sumV1 + sumV2;
		if ((sumV & 1) == 1 || sumV < max * 2) {
			return answer;
		} else {
			int chk = 0;
			int cnt = 0;
			while (chk < 10) {
				if (sumV1 > sumV2) {
					int temp = q1.poll();
					q2.add(temp);
					sumV1 -= temp;
					sumV2 += temp;
					cnt++;
					if (sumV1 < sumV2)
						chk++;
				} else if (sumV1 < sumV2) {
					int temp = q2.poll();
					q1.add(temp);
					sumV1 += temp;
					sumV2 -= temp;
					cnt++;
					if (sumV1 > sumV2)
						chk++;
				} else {
					return answer = cnt;
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		System.out.println(Solution2.solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}));
		System.out.println(Solution2.solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}));
		System.out.println(Solution2.solution(new int[] {1, 1}, new int[] {1, 5}));
	}
}
