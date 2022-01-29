package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] ascd = { 2, 3, 4, 5, 6, 7, 8 };
		int[] dscd = { 7, 6, 5, 4, 3, 2, 1 };
		int index = Integer.parseInt(st.nextToken());
		String answer = "";
		if (index == 8) {
			for (int i = 0; i < dscd.length; i++) {
				index = Integer.parseInt(st.nextToken());
				if (index != dscd[i]) {
					answer = "mixed";
					break;
				} else {
					answer = "descending";
				}
			}
		} else if (index == 1) {
			for (int i = 0; i < dscd.length; i++) {
				index = Integer.parseInt(st.nextToken());
				if (index != ascd[i]) {
					answer = "mixed";
					break;
				} else {
					answer = "ascending";
				}
			}
		} else {
			answer = "mixed";
		}
		System.out.println(answer);
	}
}
