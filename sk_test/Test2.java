package sk_test;

import java.util.Arrays;

public class Test2 {
	static int clockDelta[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우, 하, 좌, 상
	static int counterClockDelta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0}, { 0, -1 } }; // 하, 우, 상, 좌

	static int[][] answer;

	public int[][] solution(int n, boolean clockwise) {
		answer = new int[n][n];
		if (n % 2 != 0) { // n이 홀수 일 때. n* (n+1), 가운데
			answer[n / 2][n / 2] = n / 2 * (n / 2 + 1) + 1;
			// 2까지 돌리기

			if (clockwise) { // 시계방향
				clockWise(0, 0, -1, n);
				clockWise(1, -1, n - 1, n);
				clockWise(2, n - 1, n, n);
				clockWise(3, n, 0, n);
			} else { // 반시계방향
				counterClocwise(0, -1, 0, n);
				counterClocwise(1, n-1, -1, n);
				counterClocwise(2, n, n-1, n);
				counterClocwise(3, 0, n, n);
			}
		} else {
			if (clockwise) { // 시계방향
				clockWise(0, 0, -1, n);
				clockWise(1, -1, n - 1, n);
				clockWise(2, n - 1, n, n);
				clockWise(3, n, 0, n);
			} else { // 반시계방향
				counterClocwise(0, -1, 0, n);
				counterClocwise(1, n-1, -1, n);
				counterClocwise(2, n, n-1, n);
				counterClocwise(3, 0, n, n);
			}
		}

		return answer;
	}

	private void counterClocwise(int d, int r, int c, int n) {
		int index = 1; // 표기할 숫자
//		0,0
		for (int i = n - 1; i > 0; i -= 2) { // 2씩 줄어들.
			int temp = i;
			while (temp-- > 0) {
				r += counterClockDelta[d][0];
				c += counterClockDelta[d][1];
				answer[r][c] = index++;
			}
			d = (d + 1) % 4;
		}
	}

	private void clockWise(int d, int r, int c, int n) {
		int index = 1; // 표기할 숫자
//		0,0
		for (int i = n - 1; i > 0; i -= 2) { // 2씩 줄어들.
			int temp = i;
			while (temp-- > 0) {
				r += clockDelta[d][0];
				c += clockDelta[d][1];
				answer[r][c] = index++;
			}
			d = (d + 1) % 4;
		}
	}
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		
		int[][] a = t.solution(5, true);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
