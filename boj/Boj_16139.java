package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16139 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int q = Integer.parseInt(br.readLine());
		int[][] sumAlphabet = new int[str.length() + 1]['z' - 'a' + 1]; // 알파벳 갯수만큼 존재해야함
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < sumAlphabet[i].length; j++) {
				if (str.charAt(i) - 'a' == j) {
					sumAlphabet[i+1][j] = sumAlphabet[i][j] + 1;
				} else {
					sumAlphabet[i+1][j] = sumAlphabet[i][j];
				}
			}
		}
		
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			stz = new StringTokenizer(br.readLine());
			int key = stz.nextToken().charAt(0) - 'a';
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			sb.append(sumAlphabet[to+1][key] - sumAlphabet[from][key]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}