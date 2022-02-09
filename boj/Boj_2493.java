package boj;

import java.io.*;
import java.util.*;

public class Boj_2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] towerHeight = new int[n];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < towerHeight.length; i++) {
			towerHeight[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < towerHeight.length; i++) {
			while (!stack.isEmpty()) {
				if (towerHeight[stack.peek()] > towerHeight[i]) {
					sb.append((stack.peek() + 1) + " ");
					break;
				} else {
					stack.pop();
				}
			}
			if(stack.isEmpty()) {
				sb.append(0 + " ");
			}
			stack.push(i);
		}
		System.out.println(sb);
	}

}