package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1220_Magnetic {

	static int T, map[][], N, delta[][] = { { 1, 0 }, { -1, 0 } }, moveCnt, cantmoveCnt;

	public static void main(String[] args) throws IOException {

		// 입력
		T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) { // 10번째
			N = Integer.parseInt(br.readLine());
			map = new int[N][N]; // 0부터 99 인덱스까지 100개
			for (int i = 0; i < N; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stz.nextToken());
				}
			}
			while (true) {
				cantmoveCnt = 0;
				moveCnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						move(i, j);
					}
				}
				if(moveCnt == 0 )break;
			}
			
			sb.append("#"+ t + " "+ cantmoveCnt+"\n");
		}
		System.out.println(sb);
	}

	private static void move(int r, int c) {
		if (map[r][c] == 1) {
			int nr = r + delta[0][0];
			int nc = c + delta[0][1];

			if (nr == 100) { // 끝 도달
				map[r][c] = 0;
				return;
			}

			if (map[nr][nc] == 0) {// 교착 상태아니지?
				map[r][c] = 0; // 교착상태가 아니면 움직여
				map[nr][nc] = 1; //
				moveCnt++;
			}
			if(map[nr][nc]==2) {
				cantmoveCnt++;
			}

		} else if (map[r][c] == 2) {
			int nr = r + delta[1][0];
			int nc = c + delta[1][1];

			if (nr == -1) { // 끝 도달
				map[r][c] = 0;
				return;
			}

			if (map[nr][nc] == 0) {// 교착상태 아니지?
				map[r][c] = 0; // 교착상태가 아니면 움직여
				map[nr][nc] = 2; //
				moveCnt++;
			}

		}
	}
}
