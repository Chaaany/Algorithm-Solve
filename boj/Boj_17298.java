package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17298 {
	static int N, arr[], answer[], max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		answer = new int[N];

		StringTokenizer stz;
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}

		int temp = 0;
		for (int i = N - 1; i >= 0; i--) {
			boolean check = false;
			if (st.isEmpty()) {
				answer[i] = -1;
				st.push(arr[i]);
			} else if (st.peek() > arr[i]) {
				answer[i] = st.peek();
				st.push(arr[i]);
			} else {
				st.pop();
				while (!st.isEmpty()) {
					temp = st.pop();
					if (temp > arr[i]) {
						st.push(temp);
						st.push(arr[i]);
						check = true;
						answer[i] = temp;
						break;
					}
				}
				if(!check) {
					answer[i] = -1;
					st.push(arr[i]);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
