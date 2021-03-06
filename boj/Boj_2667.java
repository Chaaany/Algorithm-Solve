package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2667 {
	static int N;
	static int arr[][];
	static int answerArr[][];
	static int answer[] = new int[625];
	static int homeNumber = 1;
	static int delta[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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

		sb.append(homeNumber - 1).append("\n");
		Arrays.sort(answer);

		for (int i = answer.length - homeNumber + 1; i < answer.length; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.print(sb);

	}

	private static void dfs(int r, int c) {
		if(arr[r][c] == 0) return;
		arr[r][c] = 0;
		answer[homeNumber]++;
		
		dfs(r + delta[0][0], c + delta[0][1]);
		dfs(r + delta[1][0], c + delta[1][1]);
		dfs(r + delta[2][0], c + delta[2][1]);
		dfs(r + delta[3][0], c + delta[3][1]);
}

}
