package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7964_부먹왕국 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;
		
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			stz = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stz.nextToken());
			int D = Integer.parseInt(stz.nextToken());
			int arr[] = new int[N+2];
			arr[0] = 1;
			arr[N] = 1;
			int cursor = 0;
			stz = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <=N; i++) {
				arr[i] = Integer.parseInt(stz.nextToken());
			}
			
			
			for (int i = 0; i <= N; i++) {
				if(arr[i] == 1) {
					cursor = i;
				}
				if(cursor+D == i && arr[i] == 0) {
					cursor = i;
					arr[i] = 1;
					answer++;
				}
			}
			sb.append("#"+ t + " "+ answer+"\n");
		}
		System.out.print(sb);
		
	}
}
