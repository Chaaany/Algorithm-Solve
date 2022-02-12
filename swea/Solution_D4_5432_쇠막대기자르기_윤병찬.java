package swea;

import java.util.Scanner;

public class Solution_D4_5432_쇠막대기자르기_윤병찬 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			String c = str.replace("()", "*");

			int temp = 0;
			int answer = 0;

			for (int i = 0; i < c.length(); i++) {
				if (c.charAt(i) == '*') {
					answer += temp;
				} else if (c.charAt(i) == '(') {
					temp++;
					answer++;
				} else if (c.charAt(i) == ')') {
					temp--;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
