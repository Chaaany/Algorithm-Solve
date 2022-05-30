package 계절학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 불이야 {
	static int H, N, M, H1, N1, M1, springCoolerCnt, windowFloorCnt, springCooler[][], map[][][],
			delta[][] = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
	static Queue<int[]> q;
	static boolean[] windowFloor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");

		H = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		M = Integer.parseInt(temp[2]);
		H1 = Integer.parseInt(temp[3]);
		N1 = Integer.parseInt(temp[4]);
		M1 = Integer.parseInt(temp[5]);

		temp = br.readLine().split(" ");
		springCoolerCnt = Integer.parseInt(temp[0]);
		windowFloorCnt = Integer.parseInt(temp[1]);
		springCooler = new int[springCoolerCnt][3];
		map = new int[H + 1][N + 1][M + 1];
		windowFloor = new boolean[H + 1];

		for (int i = 0; i < springCoolerCnt; i++) {
			temp = br.readLine().split(" ");
			springCooler[i][0] = Integer.parseInt(temp[0]);
			springCooler[i][1] = Integer.parseInt(temp[1]);
			springCooler[i][2] = Integer.parseInt(temp[2]);

			map[springCooler[i][0]][springCooler[i][1]][springCooler[i][2]] = 1;
		}

		for (int i = 0; i < windowFloorCnt; i++) {
			windowFloor[Integer.parseInt(br.readLine())] = true;
		}

		q = new LinkedList<>();
		q.add(new int[] { H1, N1, M1, 0 });
		map[H1][N1][M1] = -1;
		System.out.print(check()-1);
	}

	private static int check() {
		int minuteCnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
//			System.out.println(minuteCnt+"에 불 난 곳");
			
			
			for (int i = 0; i < size; i++) {
				int temp[] = q.poll();
				int h = temp[0];
				int n = temp[1];
				int m = temp[2];
				int isSpringCooler = temp[3];
//				System.out.println(h+", "+n+", "+m+", "+isSpringCooler);
				q.add(new int[] { h, n, m, isSpringCooler});
			}
			
			for (int i = 0; i < size; i++) {
				int temp[] = q.poll();
				int h = temp[0];
				int n = temp[1];
				int m = temp[2];
				int isSpringCooler = temp[3];
				
//				for (int j = 0; j < temp.length; j++) {
//					System.out.println(temp[j]);
//				}

				if (isSpringCooler == 1) { // 스프링 쿨러로 인한 지연 처리
					q.add(new int[] { h, n, m, 0 });
					continue;
				}
				
				if (windowFloor[h]) {
//					System.out.println("-------------");
//					System.out.println(h+", "+n+", "+m+", "+isSpringCooler);
					for (int j = 0; j < delta.length; j++) {

						if (j > 2) {
							for (int k = 1; k <= 2; k++) {

								int nh = h + delta[j][0]*k;
								int nn = n + delta[j][1]*k;
								int nm = m + delta[j][2]*k;

								// 창문이 열린 층 처리
								if (!check(nh, nn, nm))
									continue;

								if (map[nh][nn][nm] == -1)
									continue;

								if (map[nh][nn][nm] == 1) {
									// 스프링 쿨러 설치된 곳이라면 지연처리를 위해 마지막 인덱스 1 추가
									map[nh][nn][nm] = -1;
									q.add(new int[] { nh, nn, nm, 1 });
								} else {
									map[nh][nn][nm] = -1;
									q.add(new int[] { nh, nn, nm , 0});
								}
							}
							
						} else {
							int nh = h + delta[j][0];
							int nn = n + delta[j][1];
							int nm = m + delta[j][2];

							// 창문이 열린 층 처리

							if (!check(nh, nn, nm))
								continue;

							if (map[nh][nn][nm] == -1)
								continue;

							if (map[nh][nn][nm] == 1) {
								// 스프링 쿨러 설치된 곳이라면 지연처리를 위해 마지막 인덱스 1 추가
								map[nh][nn][nm] = -1;
								q.add(new int[] { nh, nn, nm, 1 });
							} else {
								map[nh][nn][nm] = -1;
								q.add(new int[] { nh, nn, nm, 0 });
							}
						}
					}
//					System.out.println("-------------");
				} else { // 창문 안 열린 층 처리
					for (int j = 0; j < delta.length; j++) {
						int nh = h + delta[j][0];
						int nn = n + delta[j][1];
						int nm = m + delta[j][2];

						// 창문이 열린 층 처리

						if (!check(nh, nn, nm))
							continue;

						if (map[nh][nn][nm] == -1)
							continue;

						if (map[nh][nn][nm] == 1) {
							// 스프링 쿨러 설치된 곳이라면 지연처리를 위해 마지막 인덱스 1 추가
							map[nh][nn][nm] = -1;
							q.add(new int[] { nh, nn, nm, 1 });
						} else {
							map[nh][nn][nm] = -1;
							q.add(new int[] { nh, nn, nm, 0 });
						}
					}
				}
			}
			minuteCnt++;
		}
		return minuteCnt;
	}

	private static boolean check(int nh, int nn, int nm) {
		return 1 <= nh && nh <= H && 1 <= nn && nn <= N && 1 <= nm && nm <= M;
	}
}
