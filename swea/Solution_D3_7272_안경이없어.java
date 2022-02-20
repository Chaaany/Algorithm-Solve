package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7272_안경이없어 {
	static String dict;
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		dict = "CEFGHIJKLMNSTUVWXYZ ADOPQR B"; 
		
		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());
			
			String tempA = stz.nextToken();
			String tempB = stz.nextToken();
			String answer = "SAME";
			
			if(tempA.length() == tempB.length()) {
				for (int i = 0; i < tempB.length(); i++) {
					if(dict.indexOf((tempA.charAt(i))) <= dict.indexOf('Z') && dict.indexOf((tempB.charAt(i))) <= dict.indexOf('Z')) {
						continue;
					}else if(dict.indexOf('Z') < dict.indexOf((tempA.charAt(i))) & dict.indexOf((tempA.charAt(i))) <=dict.indexOf('R') && dict.indexOf('Z') < dict.indexOf((tempB.charAt(i))) & dict.indexOf((tempB.charAt(i))) <=dict.indexOf('R')) {
						continue;
					}else if(tempA.charAt(i) == tempB.charAt(i) && tempA.charAt(i) == 'B') {
						continue;
					} else {
						answer = "DIFF";
						break;
					}
				}
			}else {
				answer = "DIFF";
			}
			sb.append("#"+ t + " " + answer+"\n");
			
		}
		System.out.print(sb);
	}
}
