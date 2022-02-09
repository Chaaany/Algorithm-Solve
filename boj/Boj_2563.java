package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2563 {

	static int[][] paper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int N;
		N = Integer.parseInt(br.readLine());
		paper = new int[101][101];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			color(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
		}
		for (int a = 1; a < 101; a++) {
			for (int b = 1; b < 101; b++) {
				if (paper[a][b] == 1)cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void color(int r, int c) {
		for (int i = r; i < r + 10; i++) {
			for (int j = c; j < c + 10; j++) {
				paper[i][j] = 1;
			}
		}
	}
}
