package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Boj_4949 {
	static char[] bracket = { '(', '[', ')', ']' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str;

		Stack<Integer> st = new Stack<>();
		Stack<Integer> tempSt = new Stack<>();
		str = sc.nextLine();

		while (str.charAt(0) != '.') {
			int i = 0;
			while (i < str.length()) { // 괄호 stack넣기
				if (isBracket(str.charAt(i))) {
					st.push((int) str.charAt(i));
				}
				i++;
			}
			while(!st.empty()) {
				if(st.peek() == bracket[2] || st.peek() == bracket[3]) {
					tempSt.push(st.pop());
				} else if(st.peek() == bracket[0] && !tempSt.empty() && tempSt.peek() == bracket[2]) {
					st.pop();
					tempSt.pop();
				} else if(st.peek() == bracket[1] && !tempSt.empty() && tempSt.peek() == bracket[3]) {
					st.pop();
					tempSt.pop();
				} else {
					break;
				}
			}
			
			if(tempSt.empty()&&st.empty()) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}


			str = sc.nextLine(); // 새로운 문자열 받기
			st.clear();
			tempSt.clear();
		}
		System.out.println(sb);

	}

	private static boolean isBracket(char charAt) {
		for (int i = 0; i < bracket.length; i++) {
			if (charAt == bracket[i])
				return true;
		}
		return false;
	}

}
