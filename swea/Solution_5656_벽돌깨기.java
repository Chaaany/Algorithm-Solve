package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	static class Block {
		int r, c, breakCnt;

		public Block(int r, int c, int breakCnt) {
			this.r = r;
			this.c = c;
			this.breakCnt = breakCnt;
		}

	}

	static int N, W, H, arr[][], tempArr[][], nums[], delta[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }, answer,
			tempAnswer, blockCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 1 ≤ N ≤ 4
		// 2. 2 ≤ W ≤ 12
		// 3. 2 ≤ H ≤ 15
		// 완탐 : WCN => 최대 12C4 => 12*11*10*9 / 4 3 2 1 = 990번
		// 완탐 + 프루닝
		// 입력 전체 벽돌 갯수도 세놓음 -> 벽돌 다 부쉈을 때는 백트래킹
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stz.nextToken());
			W = Integer.parseInt(stz.nextToken());
			H = Integer.parseInt(stz.nextToken());
			arr = new int[H][W];
			tempArr = new int[H][W];
			answer = Integer.MIN_VALUE;
			blockCnt = 0;
			for (int i = 0; i < H; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
					if(arr[i][j] != 0) {
						blockCnt++;
					}
				}
			}
			nums = new int[N];
			nPr(0);
			
			sb.append("#").append(t).append(" ").append(blockCnt-answer).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);

	}

	// 떨어트릴 위치
	private static void nPr(int cnt) {
		if (cnt == N || answer == blockCnt) {
			// tempArr 카피

			for (int i = 0; i < arr.length; i++) {
				tempArr[i] = Arrays.copyOf(arr[i], arr[i].length);
			}
			tempAnswer = 0;
//			for (int i = 0; i < nums.length; i++) {
//				System.out.print("부수는 순서" + nums[i] + " ");
//			}
//			System.out.println("\n");
			gameStart(0);
			return;
		}

		for (int i = 0; i < W; i++) {
			nums[cnt] = i;
			nPr(cnt + 1);
		}
	}

	private static void gameStart(int cnt) {
		// 구슬을 떨어트림
		if (cnt == N) {
//			System.out.println(tempAnswer);
			answer = Math.max(answer, tempAnswer);
			return;
		}
		int r = 0;
		int c = 0;
		boolean blockCheck = false;
		for (int h = 0; h < H; h++) {
			if (tempArr[h][nums[cnt]] != 0) {// 부술 벽돌이 있니?
				r = h;
				c = nums[cnt];
				blockCheck = true;
				break;
			}
		}

		if (blockCheck) {// 부술 벽돌 있을 경우
			Queue<Block> q = new LinkedList<>();
			q.add(new Block(r, c, tempArr[r][c]));
			tempArr[r][c] = 0;// 부수고 시작
			tempAnswer++;
			bfsdfs(q); // 한 턴 플레이
			makeFlat();
			gameStart(cnt + 1);
		} else {// 없을 경우
			gameStart(cnt + 1);
		}
	}

	private static void makeFlat() {
		List<Integer> tempL = new ArrayList<>();
		
		for (int i = 0; i < W; i++) {
			tempL.clear();
			for (int j = H - 1; j >= 0; j--) {// 벽돌 빈칸 채우기
				if (tempArr[j][i] != 0) {
					tempL.add(tempArr[j][i]);
					tempArr[j][i] = 0;
				}
			}
			for (int j = 0; j < tempL.size(); j++) {
				tempArr[H - 1 - j][i] = tempL.get(j);
			}
		}
	}

	private static void bfsdfs(Queue<Block> q) {

		while (!q.isEmpty()) {
			Block tempB = q.poll();
			int r = tempB.r;
			int c = tempB.c;
			int breakCnt = tempB.breakCnt;

			for (int i = 0; i < 4; i++) {
				int tempCnt = breakCnt;
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				while (--tempCnt > 0) { // 벽돌 부수기
//					System.out.println(nr +" " +nc);
					if (!check(nr, nc))
						break; // 경계밖일 경우에는 그만 부수기

					if (tempArr[nr][nc] != 0) {// 부술 벽돌이 있을 경우
//						System.out.println(nr+","+nc+":" + tempArr[nr][nc]);
						q.add(new Block(nr, nc, tempArr[nr][nc]));
						tempAnswer++;
						tempArr[nr][nc] = 0;
					}
					nr = nr + delta[i][0];
					nc = nc + delta[i][1];
				}
			}

		}
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < H && 0 <= nc && nc < W;
	}
}
