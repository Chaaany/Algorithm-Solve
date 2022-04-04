package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 { // 상, 하, 우, 좌
	static int arr[][], N, tmpD[], delta[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }, core[][], nums[],
			coreCnt, connectedCoreCnt, connectedLineCnt, prevConnectedCoreCnt, prevConnectedLineCnt, tmpCnt, lineIndex;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			core = new int[12][2];
			coreCnt = 0;
			arr = new int[N][N];
//			arr = new int[N][N];
			tmpD = new int[] { 0, N - 1, N - 1, 0 };
			prevConnectedCoreCnt = Integer.MIN_VALUE;
			prevConnectedLineCnt = Integer.MAX_VALUE;
			lineIndex = 1;
			for (int i = 0; i < N; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
					if (arr[i][j] == 1 && (i == 0 || i == N - 1 || j == 0 || j == N - 1)) { // 가장자리에 위치해 있는 코어 방문 불가 표시
						arr[i][j] = -1;
					}
					if (arr[i][j] == 1) { // 고려해야하는 코어 저장
						core[coreCnt][0] = i;
						core[coreCnt][1] = j;
						arr[i][j] = -1;
						coreCnt++;
					}
				}
			}
			nums = new int[coreCnt];
			subSet(0);
			sb.append("#").append(t).append(" ").append(prevConnectedLineCnt).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static void subSet(int cnt) {
		if (cnt == coreCnt) {
//			for (int i = 0; i < arr.length; i++) {
//				tempArr[i] = Arrays.copyOf(arr[i], arr[i].length);
//			}
			connectedCoreCnt = 0;
			connectedLineCnt = 0;
			dfs(0, false);
			lineIndex++;
			tmpCnt++;
//			if (connectedCoreCnt == 5) {
//				for (int i = 0; i < nums.length; i++) {
//					System.out.print(nums[i] + " ");
//				}
//				System.out.print("일 때  연결된 코어 수 : " + connectedCoreCnt + ", 연결된 전선 수 : " + connectedLineCnt + "\n");
//			}
			if (connectedCoreCnt > prevConnectedCoreCnt) {
				prevConnectedCoreCnt = connectedCoreCnt;
				prevConnectedLineCnt = connectedLineCnt;
			} else if (connectedCoreCnt == prevConnectedCoreCnt) {
				prevConnectedLineCnt = Math.min(prevConnectedLineCnt, connectedLineCnt);
			}
			return;
		}
		nums[cnt] = 0;
		subSet(cnt + 1);
		nums[cnt] = 1;
		subSet(cnt + 1);
		nums[cnt] = 2;
		subSet(cnt + 1);
		nums[cnt] = 3;
		subSet(cnt + 1);

	}

	private static void dfs(int cnt, boolean chk) {
		int spareCnt = N - cnt + connectedCoreCnt;
//		
		if(spareCnt < prevConnectedCoreCnt)return;
////		
		if(spareCnt <= prevConnectedCoreCnt && connectedLineCnt >= prevConnectedLineCnt)return;
////		
		if (cnt == coreCnt)
			return;

		int r = core[cnt][0];
		int c = core[cnt][1];
		if (chk) { // 실제로 전원 연결하는 거 맞음?
			switch (nums[cnt]) {
			case 0:
				connectedCoreCnt++;
				connectedLineCnt += r - 0;
				while (true) {
					r += delta[nums[cnt]][0];
					c += delta[nums[cnt]][1];
					arr[r][c] = lineIndex;
					if (r == tmpD[0])
						return;
				}
			case 1:
				connectedCoreCnt++;
				connectedLineCnt += N - 1 - r;
				while (true) {
					r += delta[nums[cnt]][0];
					c += delta[nums[cnt]][1];
					arr[r][c] = lineIndex;
					if (r == tmpD[1])
						return;
				}
			case 2:
				connectedCoreCnt++;
				connectedLineCnt += N - 1 - c;
				while (true) {
					r += delta[nums[cnt]][0];
					c += delta[nums[cnt]][1];
					arr[r][c] = lineIndex;
					if (c == tmpD[2])
						return;
				}
			case 3:
				connectedCoreCnt++;
				connectedLineCnt += c - 0;
				while (true) {
					r += delta[nums[cnt]][0];
					c += delta[nums[cnt]][1];
					arr[r][c] = lineIndex;
					if (c == tmpD[3])
						return;
				}
			}
		} else {
			switch (nums[cnt]) {
			case 0:
				while (true) {
					r += delta[nums[cnt]][0];
					c += delta[nums[cnt]][1];
					if (arr[r][c] == -1 || arr[r][c] == lineIndex) {
						dfs(cnt + 1, false);
						break;
					} else if (r == tmpD[0]) {
						dfs(cnt, true);
						dfs(cnt + 1, false);
						break;
					}
				}
				break;
			case 1:
				while (true) {
					r += delta[nums[cnt]][0];
					c += delta[nums[cnt]][1];
					if (arr[r][c] == -1 || arr[r][c] == lineIndex) {
						dfs(cnt + 1, false);
						break;
					} else if (r == tmpD[1]) {
						dfs(cnt, true);
						dfs(cnt + 1, false);
						break;
					}
				}
				break;
			case 2:
				while (true) {
					r += delta[nums[cnt]][0];
					c += delta[nums[cnt]][1];
					if (arr[r][c] == -1 || arr[r][c] == lineIndex) {
						dfs(cnt + 1, false);
						break;
					} else if (c == tmpD[2]) {
						dfs(cnt, true);
						dfs(cnt + 1, false);
						break;
					}
				}
				break;
			case 3:
				while (true) {
					r += delta[nums[cnt]][0];
					c += delta[nums[cnt]][1];
					if (arr[r][c] == -1 || arr[r][c] == lineIndex) {
						dfs(cnt + 1, false);
						break;
					} else if (c == tmpD[3]) {
						dfs(cnt, true);
						dfs(cnt + 1, false);
						break;
					}
				}
				break;
			}

		}

	}
}
