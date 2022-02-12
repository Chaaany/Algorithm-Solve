package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1 {

	static int d[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 } }; // 가운데 탐색은 나중에 갈림길이 있으면 갈림길 쪽으로(좌,우, 위순)
	static int[][] arr;
	static int T, N;
	static int[] destination;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = 10;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) { // 테케 갯수 10개
//			지도 입력받기
			N = Integer.parseInt(br.readLine());
			arr = new int[102][102]; // 패딩으로 경계값 보기 싫음
			destination = new int[2]; // 도착지 r, c좌표

			for (int i = 1; i <= 100; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
					if (i == 100 && arr[i][j] == 2) {
						destination[0] = i;
						destination[1] = j;
					}
				}
			}
			start(destination[0], destination[1]);
			sb.append("#" + t + " " + (destination[1]-1) + "\n");

		}
		System.out.println(sb);

	}

	private static void start(int r, int c) {

		if (r == 1)
			return; // 출발지에 도달했을 때 멈춤 (패딩때문에 1이 출발지)
		for (int index = 0; index < 3; index++) { // 출발지가 아니라면
			int nr = r + d[index][0];
			int nc = c + d[index][1];
			if (arr[nr][nc] == 1) { // 길이 있다면
				destination[0] = nr; // 가라
				destination[1] = nc; // 가라
				arr[nr][nc] = 0;
				start(destination[0], destination[1]); // 또 탐색
				break;
			} 

		}


	}
}
