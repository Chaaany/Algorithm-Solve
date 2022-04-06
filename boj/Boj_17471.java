package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17471 {

	static int N, population[], nums[], tempNums[], answer = 1001;
	static boolean arr[][];
	static int parent[];

	public static void main(String[] args) throws IOException {
		// 2 <= 구역갯수(N) <= 10, 1 <= 구역 인구수 <= 100 -> 많아봐야 1000 -> int배열선언가능
		// 두 선거구로 나눠야 한다. 나눌 수 없으면 -1 출력, 나눌 수 있으면 인구 차이의 최솟값을 구해보자.
		// 나눌 수 없는 것을 어떻게 파악할까?

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		N = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine());
		population = new int[N + 1]; // 0번째 안씀 - 패딩
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(stz.nextToken());
		}

		arr = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			int from = i;
			int connected = Integer.parseInt(stz.nextToken());
			for (int j = 0; j < connected; j++) {
				int to = Integer.parseInt(stz.nextToken());
				arr[from][to] = true;
				arr[to][from] = true;
			}
		}

		nums = new int[N];
		subSet(0, 0, 0);

		if (answer == 1001) {
			System.out.println(-1);
		} else {

			System.out.println(answer);
		}
	}

	private static void subSet(int cnt, int team1Cnt, int team2Cnt) {
		if (team1Cnt == N || team2Cnt == N)
			return; // 한 지역구로만 이루어진경우 프루닝

		if (cnt == N) {
			start(team1Cnt, team2Cnt);
			return;
		}

		nums[cnt] = 1;
		subSet(cnt + 1, team1Cnt + 1, team2Cnt);
		nums[cnt] = 2;
		subSet(cnt + 1, team1Cnt, team2Cnt + 1);
	}

	private static void start(int team1Cnt, int team2Cnt) {
		tempNums = Arrays.copyOf(nums, nums.length);
		int team1 = 0;
		int team2 = 0;
		int tempAnswer = 0;
		
		// 지역구 옳게 연결되었는 지 확인
		for (int i = 0; i < nums.length; i++) {
			boolean chk = false;
			if (nums[i] == 1) { // i+1번째 지역구가 1에 속할 경우
				int from = i + 1;
				for (int j = 1; j <= N; j++) {
					if (arr[from][j] && nums[j - 1] == nums[i]) {
						chk = true;
						break;
					}
				}
				if(team1Cnt == 1)chk= true;
				if (!chk)
					return; // 지역구 선택이 올바르지 못한 경우 return
				team1 += population[i + 1];
			} else { // i+1번째 지역구가 2에 속할 경우
				int from = i + 1;
				for (int j = 1; j <= N; j++) {
					if (arr[from][j] && nums[j - 1] == nums[i]) {
						chk = true;
						break;
					}
				}
				if(team2Cnt == 1) chk = true;
				if (!chk)
					return; // 지역구 선택이 올바르지 못한 경우 return
				team2 += population[i + 1];
			}
		}
		int team1C = 0;
		int team2C = 0;
		for (int i = 0; i < N; i++) {
			if(tempNums[i] == 1) {
				int r = i+1;
				Queue<Integer> q = new LinkedList<>();
				q.add(r);
				tempNums[i] = 0;
				bfs(q, 1);
				team1C++;
			}else if(tempNums[i] == 2) {
				int r = i+1;
				Queue<Integer> q = new LinkedList<>();
				q.add(r);
				tempNums[i] = 0;
				bfs(q,2);
				team2C++;
				
			}
		}
		
		if(team1C != 1 || team2C != 1) return;
//		

//		System.out.println();
		tempAnswer = Math.abs(team1 - team2);
//		System.out.println(tempAnswer);
		answer = Math.min(tempAnswer, answer);
	}

	private static void bfs(Queue<Integer> q, int teamnums) {
		while(!q.isEmpty()) {
			int r = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(arr[r][i] &&	tempNums[i-1] == teamnums) {
					tempNums[i-1] = 0;
					q.add(i);
					
				}
			}
		}
	}

}