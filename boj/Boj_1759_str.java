package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759_str {

	static int L, C, start = 0, cnt = 0;
	static char[] arr;
	static char[] chars;
	static StringBuilder sb;
	static String vow = "aeiou";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		L = Integer.parseInt(stz.nextToken());
		C = Integer.parseInt(stz.nextToken());
		chars = new char[L];
		sb = new StringBuilder();
		arr = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(arr);
		nCr(0, 0, 0, 0);
		System.out.println(sb);

	}

	public static void nCr(int cnt, int start, int consonant, int vowel) {
		if (cnt == L) {
			if (consonant >= 2 && vowel >= 1) {
				for (int i = 0; i < chars.length; i++) {
					sb.append(chars[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			chars[cnt] = arr[i];
			nCr(cnt + 1, i + 1, consonant + (vow.indexOf(chars[cnt]) == -1 ? 1 : 0),
					vowel + (vow.indexOf(chars[cnt]) == -1 ? 0 : 1));
		}
	}
}
