package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_4047_영준이의카드카운팅 {
	static int T;
	static String s;
	static int[][] cardMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			s = br.readLine();
			int len = s.length();
			cardMap = new int[5][14]; // suit
			for (int i = 0; i < len; i += 3) {
				String cs = s.substring(i, i + 3);
				char cc = cs.charAt(0);
				int val = Integer.parseInt(cs.substring(1));
				switch (cc) {
				case 'S':
					cardMap[1][val]++;
					break;
				case 'D':
					cardMap[2][val]++;
					break;
				case 'H':
					cardMap[3][val]++;
					break;
				case 'C':
					cardMap[4][val]++;
					break;
				}

			}
			// 무늬별 카드 개수
			int[] cntS = { 0, 13, 13, 13, 13 };
			boolean isP = true;

			first: for (int i = 1; i < 5; i++) {
				for (int j = 1; j < 14; j++) {
					if (cardMap[i][j] > 1) {
						isP = false;
						break first;
					} else if (cardMap[i][j] == 1) {
						cntS[i]--;
					}
				}
			}
			
			if(!isP) {
				sb.append("ERROR\n");
			} else {
				sb.append(cntS[1]+" " + cntS[2] + " "+ cntS[3]+" "+cntS[4]+"\n");
			}
		}
		System.out.println(sb);

	}
}
