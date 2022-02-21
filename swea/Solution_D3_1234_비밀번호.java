package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D3_1234_비밀번호 {
	static int T, N;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;
		T = 10;

		for (int t = 1; t <= 10; t++) {
			Stack<String> st = new Stack<>();
			stz = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stz.nextToken());
			arr = stz.nextToken().split("");

			for (int i = 0; i < arr.length; i++) {
				if (!st.empty() && st.peek().equals(arr[i])) {
					st.pop();
				} else {
					st.push(arr[i]);
				}
			}
			sb.append("#" + t + " ");
			for (String str : st) {
				sb.append(str);
			}
			st.clear();
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
