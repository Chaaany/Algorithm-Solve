package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int answerCnt = 0;
		stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int arr[][] = new int[N][N];
		for (int j = 0; j < arr.length; j++) {
			Arrays.fill(arr[j], 1000);
		}

		for (int j = 0; j < M; j++) {
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			arr[from - 1][to - 1] = 1;
		}

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (k == j)
					continue;
				for (int p = 0; p < N; p++) {
					if (k == p || p == j)
						continue;
					arr[k][p] = Math.min(arr[k][p], arr[k][j] + arr[j][p]);
				}
			}
		}

//			for (int i = 0; i < arr.length; i++) {
//				for (int j = 0; j < arr.length; j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
		int answer[] = new int[N];
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (arr[j][k] != 1000)
					answer[j]++;
			}
			for (int k = 0; k < N; k++) {
				if (arr[k][j] != 1000)
					answer[j]++;
			}
		}
		for (int j = 0; j < answer.length; j++) {
			if (answer[j] == N - 1)
				answerCnt++;
//				System.out.print(answer[j]+" ");
		}
		System.out.println(answerCnt);
	}

}
