package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17143 {

	// 상어 객체 만들기
	static class Shark implements Comparable<Shark> {
		int r;
		int c;
		int speed;
		int direction;
		int size;

		public Shark(int r, int c, int speed, int direction, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}

		public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

		public int getSpeed() {
			return speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public int getDirection() {
			return direction;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		@Override
		public int compareTo(Shark o) {
			return this.size - o.size;
		}

	}

	static int R, C, M, sharkCatchedSize, delta[][] = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }, fishing[][];
	static List<Shark> SharkList;
	static boolean catchedShark[];

	public static void main(String[] args) throws IOException {
		// 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
		// 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
		// 3. 상어가 이동한다.

		// 두 상어가 같은 크기를 갖는 경우는 없고, 하나의 칸에 둘 이상의 상어가 있는 경우는 없다.

		// 격자판의 크기 R, C와 상어의 수 M이 주어진다. (2 ≤ R, C ≤ 100, 0 ≤ M ≤ R×C)
		// 다섯 정수 r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤
		// 10000)
		// 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는
		// 왼쪽
		// 격자판 최대 크기 = 200 = 상어의 최대 수
		// 200 x200 => 최대 40,000번
		// 겹친 상어 있는지 확인 = 39,800번 돌림

		// 필요한 로직
		// 1. 낚시꾼이동
		// 2. 낚시꾼 낚시 - 상어 제거
		// 3. 상어 이동
		// 4. 상어 위치 겹칠 시 큰 상어가 잡아먹기
		sharkCatchedSize = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stz.nextToken());
		C = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		if (M != 0) {
			SharkList = new ArrayList<>();
			sharkCatchedSize = 0;
			catchedShark = new boolean[M];
			for (int i = 0; i < M; i++) {
				stz = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(stz.nextToken());
				int c = Integer.parseInt(stz.nextToken());
				int speed = Integer.parseInt(stz.nextToken());
				int direction = Integer.parseInt(stz.nextToken());
                if(direction == 1 || direction == 2) {
					speed %=2*(R-1);
				}else if(direction == 3 || direction == 4) {
					speed %=2*(C-1);
				}
				int size = Integer.parseInt(stz.nextToken());
				SharkList.add(new Shark(r, c, speed, direction, size));
			}

			// 크기순 정렬
			Collections.sort(SharkList);

//		for (int i = 0; i < M; i++) {
//			Shark temp = SharkList.get(i);
//			System.out.println(temp.r +", " + temp.c + ", 방향: " + temp.direction +", 물고기 크기 : " + temp.size +", 물고기 빠르기 : " +temp.speed);
//		}

			for (int i = 1; i <= C; i++) { // 1. 낚시꾼 이동
//				System.out.println((i - 1) + "번째 체크 ");
//				for (int a = 0; a < M; a++) {
//					Shark temp = SharkList.get(a);
//					if (catchedShark[a]) {
//						System.out.println(temp.r + ", " + temp.c + ", 방향: " + temp.direction + ", 물고기 크기 : "
//								+ temp.size + ", 물고기 빠르기 : " + temp.speed + "는 잡혔음");
//					} else {
//						System.out.println(temp.r + ", " + temp.c + ", 방향: " + temp.direction + ", 물고기 크기 : "
//								+ temp.size + ", 물고기 빠르기 : " + temp.speed);
//					}
//				}
//				System.out.println("--------------------------");

				int expectCatchedSharkIndex = -1;
				int expectCatchedSharkRow = 100000;

				for (int j = 0; j < SharkList.size(); j++) {// 2. 낚시꾼 낚시
					if (catchedShark[j])
						continue; // 이미 잡히거나 먹힌 상어니?
					Shark temp = SharkList.get(j);
					if (temp.c == i) { // 낚시가능한 상어니?
//						System.out.println(i + "에서  " + (j + 1) + "번째 상어는 예비 후보" + temp.r + " " + temp.c + " : " + temp.size);
						expectCatchedSharkIndex = expectCatchedSharkRow > temp.r ? j : expectCatchedSharkIndex;
						expectCatchedSharkRow = Math.min(temp.r, expectCatchedSharkRow);
					}

				}
				if (expectCatchedSharkIndex != -1) { // 잡을 상어가 있다?
//					System.out.println(SharkList.get(expectCatchedSharkIndex).size + "크기인 상어 잡았음");
					sharkCatchedSize += SharkList.get(expectCatchedSharkIndex).size;

					catchedShark[expectCatchedSharkIndex] = true; // 잡은 상어로 표시
				}

				// 3. 상어 이동
				fishing = new int[R + 1][C + 1]; // 0행, 0열 패딩
				for (int j = 0; j < fishing.length; j++) {
					Arrays.fill(fishing[j], 0);
				}
				for (int j = 0; j < SharkList.size(); j++) {
					if (catchedShark[j])
						continue; // 이미 잡히거나 먹힌 상어니?
					Shark temp = SharkList.get(j);
					int sharkMovementCnt = temp.speed;
					int r = temp.r;
					int c = temp.c;
					int d = temp.direction;
					int nr = r;
					int nc = c;
					while (sharkMovementCnt-- > 0) {
						nr = r + delta[d][0];
						nc = c + delta[d][1];
						if (!check(nr, nc)) {// 경계밖일 경우 재조정
							if (d == 1 || d == 3) {
								d += 1;
							} else if (d == 2 || d == 4) {
								d -= 1;
							}
							nr = r + delta[d][0];
							nc = c + delta[d][1];
						}
						r = nr;
						c = nc;
//						System.out.println(j + "번째 물고기 이동" + nr + ", " + nc);
					}
					if (fishing[nr][nc] != 0) { // 4. 상어 위치 겹칠 시 큰 상어가 잡아먹기
//						System.out.println(fishing[nr][nc] - 1 + "번째 상어 먹힘");
						catchedShark[fishing[nr][nc] - 1] = true; // 해당 물고기는 먹힌 것 (오름차순 정렬하였으므로)
						fishing[nr][nc] = j + 1; // 더 큰 물고기가 해당 자리 차지(0번째 인덱스는 안 씀)
					} else {

						fishing[nr][nc] = j + 1;
					}
					SharkList.get(j).setR(nr);
					SharkList.get(j).setC(nc);
					SharkList.get(j).setDirection(d);
				}
			}
		}

		System.out.println(sharkCatchedSize);
	}

	private static boolean check(int nr, int nc) {
		return 1 <= nr && nr <= R && 1 <= nc && nc <= C;
	}
}