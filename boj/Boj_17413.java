package boj;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Boj_17413 {
	//53분 clear ->st마지막에 쌓인거 출력안함
	static StringBuilder sb; // 정답 입력용
	static Stack<Integer> st;

	public static void main(String[] args) throws IOException {

//		조건
//		< 시작부터 > 까지는 그대로 출력
//		공백이 아닌 경우 순서 바꿔서 출력
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		st = new Stack<>();
		sb = new StringBuilder();
		// 처리
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '<') {
				i = normal(S, i); // > 있던 자리 반환
			} else if (S.charAt(i) == ' ') { // 공백 & st 쌓여 있는 단어 있을 때 단어 역정렬
				while (!st.empty()) {
					sb.append(String.valueOf(((char) (int) st.pop())));
				}
				sb.append(" ");
			} else { // 일반 문자열이면 st에 넣기
				st.push((int) S.charAt(i));
			}

		}
//		스택에 남은거 떨어버리기
		while(!st.empty()) sb.append(String.valueOf(((char) (int) st.pop())));
		
		System.out.println(sb);

	}

	private static int normal(String S, int i) {
		int index = i;
//		st에 있는 애들 먼저 떨어버리기
		if (!st.empty()) {
			while (!st.empty()) {
				sb.append(String.valueOf(((char) (int) st.pop())));
			}
		}
		while (S.charAt(index) != '>') {
			sb.append(String.valueOf(S.charAt(index)));
			index++;
		}
		sb.append(">");
		return index;
	}
}
