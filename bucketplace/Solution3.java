package bucketplace;

import java.util.Arrays;

public class Solution3 {// 17분소요
	static int temp;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int[][] roomD = { { 1, 0 }, { 1, 1 }, { 0, 1 } };

	static int N, M, roomcnt, bathcnt;

	public static int solution(int n, int m, int room, int bath) {
		int answer = -1;
		N = n;
		M = m;
		roomcnt = room;
		bathcnt = bath;
		int arr[][] = new int[n][m];

		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], -1);
		}
		int roomSquare = room * 4;
		int bathSquare = bath * 2;
		int Square = n * m;
		int target = Square - (roomSquare + bathSquare);

		if (target <= 0) {
			temp = 0;
		} else {
			temp = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					dfs(i, j, arr, target, 0);
				}
			}

		}
		answer = temp;

		return answer;
	}

	private static void dfs(int r, int c, int[][] arr, int target, int cnt) {
		if (!check(r, c))
			return; // 경계밖이니?

		if (arr[r][c] == 0)
			return; // 이미 칠해진 곳이니?

		if (cnt == target) {
			// 목표 수 다 채웠니?
			start(arr);
		}

		int tempArr[][] = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			tempArr = Arrays.copyOf(arr, arr[i].length);
		}

		tempArr[r][c] = 0; // 방문기록

		for (int i = 0; i < 4; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];
			dfs(nr, nc, tempArr, target, cnt + 1);
		}
	}

	private static void start(int[][] arr) {
		int roomTempC = roomcnt;
		int bathTempC = bathcnt;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == -1) {
					// 방 들어갈 공간이니?
					boolean chk = true;
						for (int l  = 0; l < 3; l++) {
							if(arr[roomD[l][0]][roomD[l][1]]!= -1) {
								chk = false;
							}
						}
						if(!chk) { //방 들어갈 공간임
							for (int l  = 0; l < 3; l++) {
								arr[roomD[l][0]][roomD[l][1]] = 1;// 방은 1
							}
							roomTempC--;
						}
					}
					// 화장실 들어갈 공간이니?
					boolean chk = true;
					for (int k = 0; k < arr.length; k++) {
						if(arr[i+1])
					}
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

	public static void main(String[] args) {
		Solution3.solution(4, 5, 3, 1);
		Solution3.solution(2, 3, 1, 1);
		Solution3.solution(2, 4, 1, 1);

	}
}
