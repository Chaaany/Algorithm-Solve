package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Boj_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine())];
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int index = 1;
		while (index <= arr.length) {
			if (st.isEmpty() || st.peek() != arr[cnt]) {
				st.push(index++);
				sb.append("+\n");
			}
			while(!st.isEmpty() && st.peek() == arr[cnt]) {
				st.pop();
				sb.append("-\n");
				cnt++;
			}
		}
		System.out.println(st.isEmpty()? sb:"NO");
	}
}
