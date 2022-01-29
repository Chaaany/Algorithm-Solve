package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String tc = "";
		while ((tc = br.readLine()).charAt(0) != '0') {
			String answer = "";
			if (tc.length() != 1) {
				for (int i = 0; i < tc.length() / 2; i++) {
					if (tc.charAt(i) != tc.charAt(tc.length() - i - 1)) {
						answer = "no";
						break;
					} else {
						answer = "yes";
					}
				}
			} else {
				answer = "yes";
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
