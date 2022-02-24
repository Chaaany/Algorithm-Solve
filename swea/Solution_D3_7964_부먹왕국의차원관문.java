package swea;

import java.util.Scanner;

public class Solution_D3_7964_부먹왕국의차원관문 {
	static int T,  N, D, tanagsu[], min, cursor;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
		N = sc.nextInt();
		D = sc.nextInt();
		
		tanagsu = new int[N+2];
		tanagsu[0] = 1;
		tanagsu[N+1] = 1;
		
		for (int i = 1; i < N+1; i++) {
			tanagsu[i] = sc.nextInt();
		}
		min = 0;
		cursor = 0;
		for (int i = 0; i < N+1; i++) {
			if(tanagsu[i] == 1) {
				cursor = i;
			}else if(tanagsu[i] == 0 && cursor+D == i) {
				cursor = i;
				min++;
			}
		}
		// 100001 D = 2 (j-i-1) / D
		
		sb.append("#"+ t + " "+min+"\n");
		
		}
		System.out.print(sb);
	}
}
