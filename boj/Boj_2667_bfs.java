package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2667_bfs {
	static int N;
	static int arr[][];
	static int answerArr[][];
	static int answer[] = new int[625];
	static int homeNumber = 1;
	static int delta[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 2][N + 2];
		answerArr = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				arr[i][j] = temp[j - 1] - '0';
			}
		}
		// 단지 그루핑
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == 1) {
					dfs(i, j);
					homeNumber++;
				}
			}
		}

		System.out.println(homeNumber - 1);
		Arrays.sort(answer);

		for (int i = answer.length - homeNumber+1; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}

	private static void dfs(int r, int c) {
		answerArr[r][c] = homeNumber;
		answer[homeNumber]++;
		arr[r][c] = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];

			if (arr[nr][nc] == 1)
				dfs(nr, nc);

		}

	}

}
