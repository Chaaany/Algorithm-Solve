package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1974_스도쿠검증_윤병찬 {
	static int T, answer, arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr = new int[9][9];
		
		for (int t = 1; t <= T; t++) {
			answer = 1;
				
			for (int i = 0; i < 9; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
				}
			}
			
			check();
			
			sb.append("#" + t + " "+ answer+"\n");
		}
		System.out.print(sb);
	}
	private static void check() {
		
		// 가로줄 
		for (int i = 0; i < 9; i++) {
			if(!checkR(i)) {
				answer = 0;
				return ;
			}
		}
		
		// 세로줄
		for (int i = 0; i < 9; i++) {
			if(!checkC(i)) {
				answer = 0;
				return ;
			}
		}
		
		// 각 귀
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(!checkSquare(3*i, 3*j, 3)) {
					answer = 0;
					return;
				}
			}
		}
		
	}
	private static boolean checkSquare(int r, int c, int size) {
		boolean v[] = new boolean[10];
		
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(!v[arr[i][j]]) {
					v[arr[i][j]] = true;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	private static boolean checkR(int r) {
		boolean v[] = new boolean[10];
		
		for (int j = 0; j < 9; j++) {
			if(!v[arr[r][j]]) {
				v[arr[r][j]]= true;
			}else {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkC(int c) {
		boolean v[] = new boolean[10];
		
		for (int j = 0; j < 9; j++) {
			if(!v[arr[j][c]]) {
				v[arr[j][c]]= true;
			}else {
				return false;
			}
		}
		return true;
	}
	
	
	
}
