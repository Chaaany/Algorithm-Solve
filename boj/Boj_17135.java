package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj_17135 {
	static int N, M, D, arr[][], tempArr[][], enemyCnt, answer, nums[], archer[][];
	static List<int[]> tempEnenyList;
	static TreeSet<String> ts;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		// 궁수 3명을 놓는다 최대15C3
		// 공격을 한다 최대 15턴
		// 사거리 10 공격기준은 맨해튼 거리,가장 가까우면서 왼쪽에 있는 적을 먼저 죽임

		// O O O O
		// O O O O
		// X O O O
		// X X O O
		// X X X O

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		ts = new TreeSet<>();
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		D = Integer.parseInt(stz.nextToken());

		arr = new int[N + 1][M];

		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
				if (arr[i][j] == 1)
					enemyCnt++;
			}
		}
		answer = 0;
		nums = new int[3];
		combi(0, 0);
		System.out.println(answer);

	}

	private static void combi(int cnt, int start) {
		if (enemyCnt == answer)
			return; // 모든 적 죽일 수 있는 걸 이미 알았을 때 안 돌림

		if (cnt == 3) {
//			for (int i = 0; i < nums.length; i++) {
//				System.out.print(nums[i] + " ");
//			}
//			System.out.println();
			gameStart();
			return;
		}

		for (int i = start; i < M; i++) {
			nums[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	private static void gameStart() {
		
		visited = new boolean[N+1][M];
		ts.clear();
		int turnCnt = 1 ;
		archer = new int[][] { { N, nums[0] }, { N, nums[1] }, { N, nums[2] } };
		while (turnCnt  <= N) {// N만큼 턴 돈다.
			tempEnenyList = new ArrayList<int[]>();
//			System.out.println(turnCnt+"번째 게임");
			for (int i = 0; i < archer.length; i++) {
				aimTarget(archer[i][0], archer[i][1], D);
			}
			// 죽인 적의 수 = ts의 크기
			if (ts.size() == enemyCnt) { // 존재하는 모든 적 다 죽였을 경우
				answer = enemyCnt;
				return;
			}
			//적 죽이기
			for (int i = 0; i < tempEnenyList.size(); i++) visited[tempEnenyList.get(i)[0]][tempEnenyList.get(i)[1]] = true;
			
			// 궁수들 옮김
			archer[0][0]--;
			archer[1][0]--;
			archer[2][0]--;
			turnCnt++;
		}
		answer = Math.max(ts.size(), answer);
		
	}

	private static void aimTarget(int r, int c, int d) {
		// 가까우면서 왼쪽부터 탐색
		int prevdistance = d+1;
		int prevR = -1;
		int prevC = M+1;
		for (int i = 0; i < d; i++) {
			for (int j = (d - i - 1) * -1; j <= (d - i-1); j++) {
				int nr = r - i - 1;
				int nc = c + j;
				if (!check(nr, nc))
					continue;
//				if(ts.contains(""+nr + " " + nc))continue;
				if(visited[nr][nc])continue;
				
				if (arr[nr][nc] == 1 ) {
					int distance = Math.abs(nr-r) + Math.abs(nc-c);
					if(prevdistance > distance) { // 거리가 더 가까운 적
						prevdistance = distance;
						prevR = nr;
						prevC = nc;
					}else if(prevdistance == distance && nc < prevC) { // 거리가 같으면서 더 왼쪽에 있는 적
						prevdistance = distance;
						prevR = nr;
						prevC = nc;
					}
				}
			}
		}
		
		if(prevR == -1 && prevC == M+1)return;
//		System.out.println(prevR + " " + prevC);
		tempEnenyList.add(new int[] {prevR, prevC});
		ts.add("" + prevR + " " + prevC);
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}
}
