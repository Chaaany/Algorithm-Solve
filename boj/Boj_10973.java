package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_10973 {
	static int numbers[], input[], N;
	static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		isSelected = new boolean[N];
		input = new int[N];
		boolean check = false;
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		for (int i = 0; i < N ; i++) { // 사전순 가장 첫 번째 일 경우 체크
			if((input[i] != (i+1))) {
				check = true;
				break;
			}
		}
		if(!check) { // 사전순 가장 첫 번째 일 경우 -1 출력
			System.out.println(-1);
		} else { // 아닐 경우 탐색
			nPr(0);
		}
	}

	private static void nPr(int cnt) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i];
			isSelected[i] = true;
			nPr(cnt+1);
			isSelected[i] = false;
		}
	}

}
