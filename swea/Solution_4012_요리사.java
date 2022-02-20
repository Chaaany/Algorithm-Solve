package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int N, min, aTotal, bTotal, dif;
	static int[] foodA, foodB, elementCombi;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stz;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];
			foodA = new int[N / 2];
			foodB = new int[N / 2];
			foodA[0] = 1;
			elementCombi = new int[2];
			min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
				}
			}
			nCr(1, 2, new boolean[N + 1]);
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.print(sb);
	}

	private static void nCr(int cnt, int start, boolean v[]) {
		if (cnt == (N / 2)) {
			int count = 0;
			for (int i = 2; i <= N; i++) {
				if (!v[i]) {
					foodB[count++] = i;
				}
			}
			gap();
			return;
		}

		for (int i = start; i <= N; i++) {
			if (v[i])
				continue;

			foodA[cnt] = i;
			v[i] = true;
			nCr(cnt + 1, i + 1, v);
			v[i] = false;
		}

	}

	private static void gap() {
		scoreCn(0, 0);
		dif = Math.abs(aTotal - bTotal);
		min = Math.min(min, dif);
		aTotal = 0;
		bTotal = 0;
	}

	private static void scoreCn(int cnt, int start) {
		if (cnt == 2) {
			aTotal += arr[foodA[elementCombi[0]]][foodA[elementCombi[1]]]
					+ arr[foodA[elementCombi[1]]][foodA[elementCombi[0]]];
			bTotal += arr[foodB[elementCombi[0]]][foodB[elementCombi[1]]]
					+ arr[foodB[elementCombi[1]]][foodB[elementCombi[0]]];
			return;
		}
		for (int i = start; i < N / 2; i++) {

			elementCombi[cnt] = i;
			scoreCn(cnt + 1, i + 1);
		}
	}

}