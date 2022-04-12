package boj;

import java.util.*;

public class Boj_1541 {
	public static void main(String[] args) {
		// 양수, +, -, 괄호
		// 괄호를 적당히 쳐서 최소로 만드는 경우
		// -가 나오면 그 뒤에부터 그다음 -가 나올 때 까지 합한 수를 빼기
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String dividedStr[] = new String[50];
		int index = 0;
		int cursor = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				dividedStr[index++] = str.substring(cursor, i);
				dividedStr[index++] = str.substring(i, i + 1);
				cursor = i + 1;
			} else if (i == str.length() - 1) {
				dividedStr[index++] = str.substring(cursor, str.length());
			}
		}
		
		boolean plusOrMinus = false;
		int answer = 0;
		for (int i = 0; i < index; i++) {
			if (dividedStr[i].equals("+")) {
//				System.out.println(i + " : " + dividedStr[i]);
				continue;
			} else if (dividedStr[i].equals("-")) {
//				System.out.println(i + " : " + dividedStr[i]);
				plusOrMinus = true;
				continue;
			}

			if (!plusOrMinus) {
//				System.out.println(i + " : " + dividedStr[i]);
				answer += Integer.parseInt(dividedStr[i]);
			} else {
//				System.out.println(i + " : " + dividedStr[i]);
				answer -= Integer.parseInt(dividedStr[i]);
			}
		}
		System.out.println(answer);

	}
}
