package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FishingKing_BJ17143 {
	static int R, C, M;
	static int[][] map;
	static List<int[]> shark;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		shark = new ArrayList<int[]>();
		if (M != 0) {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				map[r - 1][c - 1] += z;
				shark.add(new int[] { r - 1, c - 1, s, d - 1, z });
			}

			int temp = 0;
			for (int i = 0; i < C; i++) { // 고기 잡기
				for (int j = 0; j < R; j++) {
					if (map[j][temp] > 0) { // 가장 가까운 물고기가 존재하니?
						result += map[j][temp]; // 있으면 잡아
						map[j][temp] = 0; // 잡고나서 없애
						break ;
					}
				}
				temp++;

				sharkMove(); // 상어 움직여
				System.out.println(i + "번째");
				for (int j = 0; j < shark.size(); j++) {
					int r = shark.get(j)[0];
					int c = shark.get(j)[1];
					int s = shark.get(j)[2];
					int d = shark.get(j)[3];
					int z = shark.get(j)[4];
					System.out.println(
							j + "번째 상어 r :" + r + ", c : " + c + ", 스피드는 :" + s + ", 방향은" + d + ", 크기는 : " + z);
				}
				System.out.println("---------------------------------");
			}
		}
		System.out.println(result);
	}

	private static void sharkMove() {
		for (int i = 0; i < shark.size(); i++) {
			int r = shark.get(i)[0];
			int c = shark.get(i)[1];
			if (map[r][c] == 0) { // 이미 잡은 상어니?
				shark.remove(i); // 그럼 죽여버려!
				i--; // size 줄었으니 인덱스 조절
				continue;
			}

			int s = shark.get(i)[2];
			int d = shark.get(i)[3];
			int z = shark.get(i)[4];

			if (d <= 1) // 왕복 금지!
				s %= (R - 1) * 2;
			else if (d > 1)
				s %= (C - 1) * 2;
			map[r][c] -= z;

			for (int j = 0; j < s; j++) {
				if (r + dr[d] < 0 || r + dr[d] >= R || c + dc[d] < 0 || c + dc[d] >= C) {
					if (d == 0)
						d = 1;
					else if (d == 1)
						d = 0;
					else if (d == 2)
						d = 3;
					else if (d == 3)
						d = 2;
				}
				r = r + dr[d];
				c = c + dc[d];
				System.out.println(i + "번째 상어 " + j + "번 움직인 후 r :" + r + ", c: " + c);
			}
			System.out.println(i + "번째 상어 최종 위치 r :" + r + ", c: " + c);

			shark.set(i, new int[] { r, c, s, d, z });
		}
		sharkEat();
	}

	private static void sharkEat() {
		int[][] eat = new int[R][C];
		for (int i = 0; i < shark.size(); i++) {
			int r = shark.get(i)[0];
			int c = shark.get(i)[1];
			int z = shark.get(i)[4];
			if (map[r][c] == 0) {
				map[r][c] = z;
				eat[r][c] = i;
			} else {
				if (map[r][c] > z) {
					shark.remove(i);
					i--;
				} else {
					map[r][c] = z;
					shark.remove(eat[r][c]);
					i--;
					eat[r][c] = i;

				}
			}

		}
	}
}
