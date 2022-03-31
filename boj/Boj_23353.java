package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_23353 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 바둑판 N*N <=1000000 => int[]
		// 가로, 세로, 대각선 중 하나의 방향에 연속하여 존재하는 가장 긴 흑돌의 길이
		// 하나의 백돌을 바꿀 수 있을 때 흑돌의 길이가 최대가 되는 경우를 구하시오
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int delta[][] = {{-1,-1},{-1,0},{0,-1}, {-1,1}};
		int max = -1;
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		
		int dp[][][] = new int[n+2][n+2][8]; // 3차원의 0번째부터 인덱스 = 흑돌 대각선, 흑돌 행, 흑돌 열, 백돌 대각선, 백돌 행, 백돌 열
		int arr[][] = new int[n+2][n+2];
		int answer[][][] = new int[n+2][n+2][8]; //1번째는 흑돌일 때 answer 2번째는 백돌일 때 answer
		for (int i = 1; i <= n; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
				// 흑돌일 경우
				if(arr[i][j] == 1) {// 흑돌로만 놓여진 경우의 dp배열에 넣어두기
					for (int k = 0; k < 4; k++) {
						dp[i][j][k] = dp[i+delta[k][0]][j+delta[k][1]][k]+1; 
					}
				}
			}
		}
		
		// 흑돌이 최대가 되는 경우는
		// 1. 그냥 백돌이 없는 흑돌의 나열이 제일 김
		// 2. 백돌이 흑돌 사이에 하나 있어서 그거 연결하니까 제일 김
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
//				n번째가 흑돌일 경우의 최댓값 = 1 + math.max((이전 돌에서 흑돌로만 놓여져 있는 경우), (이전 돌까지 중 흰돌이 하나 놓여져 있는 경우의 최댓값))
				if(arr[i][j] == 1) {// 흑돌이 놓여진 경우
					for (int k = 0; k < 4; k++) {
						
						answer[i][j][k] = 1 + Math.max(dp[i+delta[k][0]][j+delta[k][1]][k], answer[i+delta[k][0]][j+delta[k][1]][k+4]); 
						answer[i][j][k+4] = answer[i][j][k];
						
						max = Math.max(max, answer[i][j][k]);
					}
				}else if(arr[i][j] == 2) {
//				n번째가 백돌일 경우의 최댓값 = (이전 돌에서 흑돌로만 놓여져 있는 경우)+1
					for (int k = 0; k < 4; k++) {
						answer[i][j][k+4] = dp[i+delta[k][0]][j+delta[k][1]][k]+1;
						max = Math.max(max, answer[i][j][k+4]);
					}
				}
			}
		}

		System.out.println(max);
		
	}
}
