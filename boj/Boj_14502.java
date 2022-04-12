package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
	static int arr[][], N, M, nums[], noneCnt, blockCnt, virusCnt, delta[][] = {{-1,0},{1,0},{0,1},{0,-1}}, answer;
	static List<int[]> noneList, virusList;
	public static void main(String[] args) throws IOException {
		// 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳
		// 벽 3개를 반드시 세워서 확보할 수 있는 최대의 안전영역은?
		// combination && bfs + 백트래킹
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		arr = new int[N][M];
		virusList = new LinkedList<>();
		noneList = new ArrayList<>(); 
		noneCnt = 0;
		blockCnt = 0; 
		virusCnt = 0;
		answer = -1;
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
				if(arr[i][j] == 0) { // 안전영역 후보이자 벽 세울 후보
					noneList.add(new int[] {i, j});
					noneCnt++;
				}else if(arr[i][j] == 1) { // 벽 갯수 세어 두기
					blockCnt++;
				}else if(arr[i][j] == 2) {
					virusCnt++;
					virusList.add(new int[] {i, j});
				}
			}
		}
		nums = new int[3];//벽 세울 후보지 = 현재 안전영역
		combi(0, 0);
		System.out.println(answer);
	}

	private static void combi(int cnt, int start) {
		if(cnt == 3) {
			boolean visited[][] = new boolean[N][M];
			for (int j = 0; j < nums.length; j++) { // 기둥 세우기
				int temp[] = noneList.get(nums[j]);
				visited[temp[0]][temp[1]] = true;
			}
			bfs(visited);
			return;
		}
		
		for (int i = start; i < noneCnt; i++) {
			nums[cnt] = i;
			combi(cnt+1, i+1);
		}
	}

	private static void bfs(boolean visited[][]) {
		int tempVirusCnt = virusCnt;
		int tempNoneCnt = noneCnt-3;
//		System.out.println(tempNoneCnt);
		Queue<int[]> tempVirusList = new LinkedList<int[]>();
		for (int i = 0; i < virusList.size(); i++) {
			int r = virusList.get(i)[0];
			int c = virusList.get(i)[1];
			visited[r][c] = true;
			tempVirusList.offer(new int[] {r, c});
		}
		
		while(!tempVirusList.isEmpty() && tempNoneCnt > answer) {
			int temp[] = tempVirusList.poll();
			int r = temp[0];
			int c = temp[1];
//			System.out.println(r + " "+ c);
			for (int i = 0; i < 4; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				
				if(!check(nr, nc)) continue;
				
				if(visited[nr][nc] || arr[nr][nc] == 1 || arr[nr][nc] == 2)continue; // 기방문 한 곳 또는 안전영역 아닌 곳
				
				tempNoneCnt--;//안전영역 줄여주기(바이러스 침투)
				visited[nr][nc] = true; // 방문 처리
				tempVirusList.offer(new int[] {nr, nc});// 큐에 넣어주기
			}
		}
//		System.out.println(tempNoneCnt);
//		System.out.println("끝");
		answer = Math.max(answer, tempNoneCnt);
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}
}
