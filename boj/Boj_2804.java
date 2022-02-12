package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2804 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		String A, B;
		int indexA = 30, indexB = 0;
		char answer[][];

		A = sc.next();
		B = sc.next();
		answer = new char[B.length()][A.length()];

		for (int i = 0; i < answer.length; i++) { // .으로 초기화
			Arrays.fill(answer[i], '.');
		}

		// 처리
		for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
			int tempA = A.indexOf(String.valueOf((char) i));
			int tempB = B.indexOf(String.valueOf((char) i));

			if (tempA != -1 && tempB != -1) {
				indexA = Math.min(indexA, tempA); // 맨처음 등장하는 교집합 단어 확인
			}
		}
		indexB = B.indexOf(String.valueOf((char)A.charAt(indexA))); // A기준 맨처음 교집합 B인덱스로 넣기

		// A의 인덱스 = B의 열 , B의 인덱스 A의 행
		for (int a = 0; a < A.length(); a++) { // A삽입
			answer[indexB][a] = A.charAt(a);
		}
		for (int b = 0; b < B.length(); b++) { // B삽입
			answer[b][indexA] = B.charAt(b);
		}
//		출력
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}

	}
}
