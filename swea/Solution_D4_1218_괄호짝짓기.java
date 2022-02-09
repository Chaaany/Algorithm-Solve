package swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		Stack<Integer> tempSt = new Stack<>();
		char[] temp;
		Scanner sc = new Scanner(System.in);
		int T = 0;
		for (int i = 1; i <= 10; i++) {
			T = sc.nextInt();
			temp = sc.next().toCharArray();
			int cnt = 0;
			while (cnt < T) {
				if (temp[cnt] == '(' || temp[cnt] == '[' || temp[cnt] == '{' || temp[cnt] == '<') {// 여는 괄호는 stack에 넣기
					st.push((int) temp[cnt]);
				} else if (temp[cnt] == ')' && !st.empty() && st.peek() == '(') {// 닫는 괄호면 stack peek로 여는 괄호 짝 있는지 확인
					st.pop();
				} else if (temp[cnt] == ']' && !st.empty() && st.peek() == '[') {// 닫는 괄호면 stack peek로 여는 괄호 짝 있는지 확인
					st.pop();
				} else if (temp[cnt] == '>' && !st.empty() && st.peek() == '<') {// 닫는 괄호면 stack peek로 여는 괄호 짝 있는지 확인
					st.pop();
				} else if (temp[cnt] == '}' && !st.empty() && st.peek() == '{') {// 닫는 괄호면 stack peek로 여는 괄호 짝 있는지 확인
					st.pop();
				} else {
					break;
				}
				cnt++;
			}

			System.out.println(cnt == T ? "#" + i + " " + 1 : "#" + i + " " + 0);
			st.clear();
		}
	}
}
