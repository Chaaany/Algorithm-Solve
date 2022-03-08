package boj;

import java.util.Arrays;
import java.util.Scanner;


public class Boj_2447 {
	static char map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i],' ');
		}
		makeStar(0, 0, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void makeStar(int r, int c, int N) {
		int size = N / 3;
		if (size == 0) {
			map[r][c] = '*';
			return;
		}
		// 1,2,3
		makeStar(r, c, size);
		makeStar(r, c + size, size);
		makeStar(r, c + 2 * size, size);

		makeStar(r + size, c, size);
//		makeStar(r+size, c+size, size); -> 별 없음
		makeStar(r + size, c + 2 * size, size);

		makeStar(r + 2 * size, c, size);
		makeStar(r + 2 * size, c + size, size);
		makeStar(r + 2 * size, c + 2 * size, size);

	}
}
