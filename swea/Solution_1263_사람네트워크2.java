package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stz.nextToken());
			int answer = 1000000;
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
					if(i != j && arr[i][j] == 0)arr[i][j] = 1000000;
				}
			}
//			dp[i][j] = max(arr[i][j], dp[i][j] + dp[j][k]);
			

			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j)continue;
					for (int k = 0; k < N; k++) {
						if(k == j || k == i)continue;
						arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
					}
				}
			}
			
			int answerArr[] = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j)continue;
					answerArr[i] += arr[i][j];
				}
				answer = Math.min(answer, answerArr[i]);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
