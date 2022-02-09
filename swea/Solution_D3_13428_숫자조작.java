package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_13428_숫자조작 {
	static int T;
	static int[] inputInt;
	static int max;
	static int min;
	static BufferedReader br;
	static StringBuilder sb;
	static StringBuilder input;
	static int[] index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			input = new StringBuilder();
			input.append(br.readLine().trim());
			max = Integer.parseInt(input.toString());
			min = Integer.parseInt(input.toString());
			index = new int[2];
			combi(0, 0);
			sb.append("#" + t + " " + min + " " + max + "\n");
		}
		System.out.println(sb);

	}

	private static void combi(int cnt, int start) {
		StringBuilder temp = new StringBuilder();
		temp.append(input);
		if (cnt == 2) {
			if (temp.charAt(index[1]) == '0' && index[0] == 0 )
				return; // 0 있으면 X
			char tempA = input.charAt(index[0]);
			char tempB = input.charAt(index[1]);
			temp.setCharAt(index[0], tempB);
			temp.setCharAt(index[1], tempA);
			max = Math.max(Integer.parseInt(temp.toString()), max);
			min = Math.min(Integer.parseInt(temp.toString()), min);
			return;
		} 

		for (int i = start; i < input.length(); i++) {
			index[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
}
