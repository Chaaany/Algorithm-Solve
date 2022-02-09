package makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intermediate_기지국_윤병찬 {

	static char[][] arr;
	static int T, N;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 처리
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {// T만큼 반복
			N = Integer.parseInt(br.readLine()); // N 입력
			arr = new char[N][]; // 패딩 안씀
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] < 'D') {
						check(i, j, arr[i][j] - 'A' + 1);
//					switch (arr[i][j]) {
//					case 'A':
//						checkA(i, j);
//						break;
//					case 'B':
//						checkB(i, j);
//						break;
//					case 'C':
//						checkC(i, j);
//						break;
					}
				}
			}

			// 출력
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = arr[i][j] == 'H' ? cnt + 1 : cnt;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}

	}

	private static void check(int r, int c, int cnt) {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= cnt; j++) {
				int nr = r + dr[i] * j;
				int nc = c + dc[i] * j;
				if (!isOutOfBoundary(nr, nc) && arr[nr][nc] == 'H') {
					arr[nr][nc] = 'X';
				}
			}
		}
	}
//
//	private static void checkB(int r, int c) {
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//			if (!isOutOfBoundary(nr, nc)) {
//				if(arr[nr][nc]=='H')arr[nr][nc] = 'X';
//				nr += dr[i];
//				nc += dc[i];
//				if (!isOutOfBoundary(nr, nc)) {
//					if(arr[nr][nc]=='H')arr[nr][nc] = 'X';
//				}
//			}
//		}
//	}
//
//	private static void checkC(int r, int c) {
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//			if (!isOutOfBoundary(nr, nc)) {
//				if(arr[nr][nc]=='H')arr[nr][nc] = 'X';
//				nr += dr[i];
//				nc += dc[i];
//				if (!isOutOfBoundary(nr, nc)) {
//					if(arr[nr][nc]=='H')arr[nr][nc] = 'X';
//					nr += dr[i];
//					nc += dc[i];
//					if (!isOutOfBoundary(nr, nc)) {
//						if(arr[nr][nc]=='H')arr[nr][nc] = 'X';
//					}
//				}
//			}
//		}
//	}

	private static boolean isOutOfBoundary(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= N;
	}

}
