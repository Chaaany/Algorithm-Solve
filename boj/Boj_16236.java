package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16236 {
	static int fishCnt, fishEaten, sharkSize = 2, aqua[][], aquaSize, sharkLoc[], min, movinTime, tempAqua[][],
			delta[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Queue<int[]> q;
	static List<int[]> fishList, tempList;
	static boolean doMove;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		aquaSize = Integer.parseInt(br.readLine());
		aqua = new int[aquaSize][aquaSize];
		tempAqua = new int[aquaSize][aquaSize];
		fishList = new ArrayList<>();
		tempList = new ArrayList<>();
		sharkLoc = new int[2];

		for (int i = 0; i < aquaSize; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < aquaSize; j++) {
				aqua[i][j] = Integer.parseInt(stz.nextToken());
				if (aqua[i][j] != 0 && aqua[i][j] != 9) {
					fishList.add(new int[] { i, j, aqua[i][j] }); // r, c, 크기
					fishCnt++;
				} else if (aqua[i][j] == 9) { // 상어 위치
					sharkLoc[0] = i;
					sharkLoc[1] = j;
				}
			}
		}
		fishList.sort((a, b) -> {
			return a[2] - b[2];
		}); // 크기순 오름차순 정렬

		if (fishCnt == 0) { // 먹을 수 있는 고기가 있니?
			System.out.println(0);
		} else {
			while (true) { // 아기상어 사냥 시작
				q = new LinkedList<>();
				tempList.clear(); // 다시 사냥 시작
				tempAqua = new int[aquaSize][aquaSize];
				doMove = false; // 다시 사냥 시작
				for (int i = 0; i < fishList.size(); i++) {
					if (fishList.get(i)[2] < sharkSize && aqua[fishList.get(i)[0]][fishList.get(i)[1]] != 0) {// 먹을 수 있는
																												// 물고기니?
						tempList.add(fishList.get(i)); // 먹을 수 있으면 일단 keep
					}
				}

				if (tempList.size() == 0) { // 먹을 고기가 없음
					break;
				} else if (tempList.size() == 1) { // 먹을 고기가 하나다?
					min = Integer.MAX_VALUE;
					q.add(new int[] {tempList.get(0)[0], tempList.get(0)[1]});
					bfs(q, 0);
					if (doMove) {
						aqua[sharkLoc[0]][sharkLoc[1]] = 0;
						sharkLoc[0] = tempList.get(0)[0]; // 상어 위치 이동
						sharkLoc[1] = tempList.get(0)[1]; // 상어 위치 이동
						aqua[sharkLoc[0]][sharkLoc[1]] = 9;
						fishEaten++; // 77ㅓ억
						movinTime += min;// 이동한 시간
						aqua[tempList.get(0)[0]][tempList.get(0)[1]] = 0; // 먹은 고기 표시
						if (fishEaten == sharkSize) {
							sharkSize++;
							fishEaten = 0;
						}
					}
				} else {

					for (int i = 0; i < tempList.size(); i++) {
						tempList.set(i,
								new int[] { tempList.get(i)[0], tempList.get(i)[1],
										Math.abs(sharkLoc[0] - tempList.get(i)[0])
												+ Math.abs(sharkLoc[1] - tempList.get(i)[1]) }); // 상어 위치로 부터의 거리를
						// 3번째 인덱스로 갱신
					}
					tempList.sort((a, b) -> {
						if (a[2] != b[2]) {
							return a[2] - b[2]; // 거리기준 오름차순
						} else { // 거리가 같다면 위쪽에 있는 물고기
							if (a[0] != b[0]) {
								return a[0] - b[0];
							}
							return a[1] - b[1]; // 같은 행이면 열이 더 왼쪽인 물고기
						}
					});

					for (int i = 0; i < tempList.size(); i++) {
						min = Integer.MAX_VALUE;
						
						q.add(new int[] {tempList.get(i)[0], tempList.get(i)[1]});
						bfs(q, 0);
						if (doMove) {
							aqua[sharkLoc[0]][sharkLoc[1]] = 0;
							sharkLoc[0] = tempList.get(i)[0]; // 상어 위치 이동
							sharkLoc[1] = tempList.get(i)[1]; // 상어 위치 이동
							aqua[sharkLoc[0]][sharkLoc[1]] = 9;
							fishEaten++; // 77ㅓ억
							movinTime += min;// 이동한 시간
							aqua[tempList.get(i)[0]][tempList.get(i)[1]] = 0; // 먹은 고기 표시
							if (fishEaten == sharkSize) {
								sharkSize++;
								fishEaten = 0;
							}
							break;
						}
					}
				}
				// 상어가 그래서 이동 했니?
				if (!doMove)
					break; // 이동 안했으면 끝내!
			}

			System.out.println(movinTime);
		}

	}

	private static void bfs(Queue<int[]> q, int distance) { // bfs로 거리 구하기
		Queue<int[]> nextQ = new LinkedList<>();
		
		while (!q.isEmpty()) {
			int[] start = q.poll();
			int r = start[0];
			int c = start[1];

			if (r == sharkLoc[0] && c == sharkLoc[1]) {
				min = Math.min(min, distance);
				doMove = true;
				return;
			}

			for (int i = 0; i < delta.length; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				if (!check(nr, nc))
					continue; // 갈 수 있는 곳이니
				tempAqua[r][c] = -1; // 방문 표시
				nextQ.offer(new int[] { nr, nc });
			}
		}

		bfs(nextQ, distance + 1);
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < aquaSize && 0 <= nc && nc < aquaSize && (aqua[nr][nc] <= sharkSize || aqua[nr][nc] == 9)
				&& tempAqua[nr][nc] != -1;
	}
}
