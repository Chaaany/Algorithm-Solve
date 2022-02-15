package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16927_배열돌리기2 {
	static int N, M, R, startN, startR;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		R = Integer.parseInt(stz.nextToken());

		arr = new int[N + 2][M + 2]; // padding 1~N, 1~M까지만 사용
		arr = new int[N + 2][M + 2]; // 임시답안으로 사용할 배열

		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {

				arr[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		
		for (int i = 1; i <= Math.min(N, M) / 2; i++) {// 회전 시작
			startN = i;
			startR = i;
			counterClockwise(i, i, R);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void counterClockwise(int r, int c, int count) {
		int rowStart = r, rowEnd = N - r + 1, colStart = c, colEnd = M - c + 1;
		int realCount = count % ((rowEnd - rowStart - 1) * 2 + (colEnd - colStart + 1) * 2);

		while (realCount-- > 0) {
//		상변	
			int tempStart = arr[r][c];
			for (int i = colStart; i < colEnd; i++) {
				arr[r][i] = arr[r][i + 1];
			}
//		우변
			for (int i = rowStart; i < rowEnd; i++) {
				arr[i][colEnd] = arr[i + 1][colEnd];
			}
//		하변
			for (int i = colEnd; i > colStart; i--) {
				arr[rowEnd][i] = arr[rowEnd][i - 1];
			}
//		좌변
			for (int i = rowEnd; i > rowStart; i--) {
				arr[i][colStart] = arr[i - 1][colStart];
			}
			arr[r + 1][c] = tempStart;
		}
	}

}