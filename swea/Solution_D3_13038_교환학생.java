package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_13038_교환학생 {

	static int T, N, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			stz = new StringTokenizer(br.readLine());
			int cnt = 0;
			
			for (int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(stz.nextToken());
				cnt++;
			}
			
			int routineCnt = N/cnt;
			int spareCnt = N%cnt;
			int stayingCnt = 0;
			
			if(routineCnt == 1 && spareCnt == 0) { // 1일만 수업 수강
				sb.append(1).append("\n");
				continue;
			} else {
				
			}
			
			for (int i = 0; i < 7; i++) {
				
			}
			
		}

	}
}
