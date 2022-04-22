package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_Dolce_Vita {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		for (int i = 0; i < T; i++) {
			stz = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(stz.nextToken());
			int coin = Integer.parseInt(stz.nextToken());
			int arr[] = new int[n];
			stz = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(stz.nextToken());
			}
			
			int answer = 0;
			Arrays.sort(arr);
			int dayCnt = 0;
			while (true) {
				int total = 0;
				int cnt = 0;
				for (int k = 0; k < arr.length; k++) {
					total+= (arr[k]+dayCnt);
					if(total <= coin) {
						cnt++;
					}else {
						break;
					}
				}
				answer+= cnt;
				if(arr[0]+dayCnt > coin)break;
				dayCnt++;
			}
			sb.append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
