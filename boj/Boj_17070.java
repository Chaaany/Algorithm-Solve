package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17070 {
	static int count, arr[][], N, deltaIndex = 1,
			delta[][][] = { { { 0, 1 }, { 1, 1 } }, { { 1, 0 }, { 1, 1 } }, { { 0, 1 }, { 1, 0 }, { 1, 1 } } }; // 가로,
																												// 세로,
																												// 대각선 일
																												// 때 가능한
																												// delta

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		arr = new int[N + 1][N + 1]; // 0행, 0열 안씀

		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
			}
		}

		dfs(1, 2, 0); // 가로로 놓여있음
		System.out.println(count);
	}

	private static void dfs(int r, int c, int dIndex) {
		if (!check(r, c, dIndex))
			return;

		if (r == N && c == N) {
			count++;
			return;
		}

		if (dIndex == 0) {
			dfs(r + delta[0][0][0], c + delta[0][0][1], 0);
			dfs(r + delta[0][1][0], c + delta[0][1][1], 2);
		} else if (dIndex == 1) {
			dfs(r + delta[1][0][0], c + delta[1][0][1], 1);
			dfs(r + delta[1][1][0], c + delta[1][1][1], 2);
		} else if (dIndex == 2) {
			dfs(r + delta[2][0][0], c + delta[2][0][1], 0);
			dfs(r + delta[2][1][0], c + delta[2][1][1], 1);
			dfs(r + delta[2][2][0], c + delta[2][2][1], 2);
		}
	}

	private static boolean check(int r, int c, int dIndex) {
		if (dIndex != 2) {
			return 1 <= r && r <= N && 1 <= c && c <= N && arr[r][c] != 1;
		} else {
			return 1 <= r && r <= N && 1 <= c && c <= N && arr[r - 1][c] != 1 && arr[r][c] != 1 && arr[r][c - 1] != 1;
		}
	}
}
