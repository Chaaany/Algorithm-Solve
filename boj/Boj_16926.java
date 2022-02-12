package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Boj_16926 {
	static int N, M, spinCnt, d;
	static int arr[][], answerArr[][]; // 스왑할 배열
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // 회전 방향 하 우 상 좌
	static int start[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		spinCnt = Integer.parseInt(stz.nextToken());
		arr = new int[N + 2][M + 2];
		answerArr = new int[N + 2][M + 2];
		start = new int[2];
		d = 0;
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		while (spinCnt-- > 0) {
			int min = Math.min(M, N);
			for (int i = 1; i <= min / 2; i++) {
				start[0] = i;
				start[1] = i;
				countClockWise(i, i);
				d = 0;
				// 회전 후 복사
			}
			for (int j = 1; j <= N; j++) {
				System.arraycopy(answerArr[j], 1, arr[j], 1, M);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void countClockWise(int r, int c) {
		int nr = r + delta[d][0];
		int nc = c + delta[d][1];

		while (arr[nr][nc] == 0) {
			if (nr == start[0] && nc == start[1]) {
				answerArr[nr][nr] = arr[r][c];
				break;
			}
			d = (d + 1);
			if (d == 4) {
				answerArr[r][c] = arr[r][c];
				return;
			}
			nr = r + delta[d][0];
			nc = c + delta[d][1];
		}
		if (nr == start[0] && nc == start[1]) {
			answerArr[nr][nc] = arr[r][c];
			arr[r][c] = 0;
			return;
		} else {
			answerArr[nr][nc] = arr[r][c];
			arr[r][c] = 0;
			countClockWise(nr, nc);
		}
	}
}