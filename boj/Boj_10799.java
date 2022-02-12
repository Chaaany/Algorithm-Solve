package boj;

import java.util.Scanner;

public class Boj_10799 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

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
		System.out.println(answer);
	}
}
