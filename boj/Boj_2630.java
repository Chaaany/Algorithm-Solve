package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2630 {
	static int countWhite;
	static int countColored;

	public static void main(String[] args) throws NumberFormatException, IOException {
		countColored = 0;
		countWhite = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int N;
		N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
//		색종이 입력
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
//		처리
		split(arr);
		System.out.println(countWhite);
		System.out.println(countColored);

	}

	public static void split(int[][] arr) {
		boolean isNotColored = false;
		if (arr.length == 1) { // 색종이 못 나눌 때
			if (arr[0][0] == 1)
				countColored++; // 색칠되어 있으면 ++
			else {
				countWhite++;
			}
		} else { // 색종이가 나눠 질 때
			int tempWhiteCnt = 0;
			for (int i = 0; i < arr.length; i++) {// 색종이가 하나라도 색칠되어 있지 않을 때 탐색
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] == 0) {
						isNotColored = true;
						tempWhiteCnt++;
					}
				}
			}

			// 색종이가 하나라도 색칠되어 있지 않다면?
			if (isNotColored && tempWhiteCnt != arr.length * arr.length) {
//				1
				int temp[][] = new int[arr.length / 2][arr.length / 2];
				for (int nr = 0, r = 0; nr < arr.length / 2; nr++, r++) {
					for (int nc = 0, c = 0; nc < arr.length / 2; nc++, c++) {
						temp[r][c] = arr[nr][nc];
					}
				}
				split(temp); // 1

//				2
				for (int nr = 0, r = 0; nr < arr.length / 2; nr++, r++) {
					for (int nc = arr.length / 2, c = 0; nc < arr.length; nc++, c++) {
						temp[r][c] = arr[nr][nc];
					}
				}
				split(temp); // 2

//				3
				for (int nr = arr.length / 2, r = 0; nr < arr.length; nr++, r++) {
					for (int nc = 0, c = 0; nc < arr.length / 2; nc++, c++) {
						temp[r][c] = arr[nr][nc];
					}
				}
				split(temp); // 3

//				4
				for (int nr = arr.length / 2, r = 0; nr < arr.length; nr++, r++) {
					for (int nc = arr.length / 2, c = 0; nc < arr.length; nc++, c++) {
						temp[r][c] = arr[nr][nc];
					}
				}
				split(temp); // 4
			} else if (isNotColored && tempWhiteCnt == arr.length * arr.length) { // 전부 색칠되어 있지 않다면
				countWhite++;
			} else if (!isNotColored) {
				countColored++; // 전부 색칠되어 있다면
			}
		}
	}
}
