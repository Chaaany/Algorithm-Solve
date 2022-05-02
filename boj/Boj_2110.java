package boj;

import java.io.*;
import java.util.*;

public class Boj_2110 {
	// 1 1 X
	// 1 5 1 5
	// 1 2 5 2 5
	// 1 2 5 10 2 5 10
	// -99 1 2 5 10 2 -99 5 10
	// -99 1 2 5 7 10 2 -99 5 7 10
	// -99 1 2 5 5 7 10 5 -99 5 7 10
	// 홀수면 N/2, 짝수면 N/2-1번째 인덱스의 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> rightPq = new PriorityQueue<>();
		PriorityQueue<Integer> leftPq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		int center = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (i == 0) {
				sb.append(temp).append("\n");
				leftPq.add(temp); // 왼쪽의 제일 큰값
			} else {
				if (leftPq.size() > rightPq.size()) { // 왼쪽 큐가 오른쪽 큐 보다 더 많은 원소가 있을 때
					int leftMax = leftPq.poll();
					if (leftMax <= temp) { // 왼쪽 큐의 Max값보다 들어온 수가 더 크거나 같을 때는 오른쪽 큐에 넣으면서 가운데수는 왼쪽큐의 max
						sb.append(leftMax).append("\n");
						leftPq.add(leftMax);
						rightPq.add(temp);
					} else { // 왼쪽 큐의 Max 보다 작을 때는 왼쪽큐의 max를 오른쪽큐에 넣으면서 왼쪽 큐의 Max와 비교한 후 max보다 크면 center 아니면
								// 왼쪽큐의 max가 가운데이며 다시 넣어줌
						rightPq.add(leftMax);
						if (leftPq.isEmpty()) {
							sb.append(temp).append("\n");
							leftPq.add(temp);
						} else {
							center = leftPq.poll();
							if (center <= temp) {
								sb.append(temp).append("\n");
							} else {
								sb.append(center).append("\n");
							}
							leftPq.add(center);
							leftPq.add(temp);
						}
					}
				} else if (leftPq.size() == rightPq.size()) { // 갯수가 같을 때
					int rightmin = rightPq.poll();
					if (rightmin <= temp) {
						sb.append(rightmin).append("\n");
						leftPq.add(rightmin);
						rightPq.add(temp);
					} else {
						rightPq.add(rightmin);
						center = leftPq.poll();
						if (center <= temp) {
							sb.append(temp).append("\n");
						} else {
							sb.append(center).append("\n");
						}
						leftPq.add(center);
						leftPq.add(temp);
					}
				}
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);

	}
}
