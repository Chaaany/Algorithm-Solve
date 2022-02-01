package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9012 {
	private static StringBuilder ps;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			ps = new StringBuilder(br.readLine());
			if(ps.length()%2 != 0) {
				sb.append("NO\n");
			} else {
				sb.append(check()).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static String check() {
		int indexOfsuf =  ps.indexOf(")") != -1 ? ps.indexOf(")") : -1;
		if (ps.length() == 0) {
			return "YES";
		}else if(indexOfsuf >= 1 && ps.charAt(indexOfsuf-1) == '(') {
			ps.deleteCharAt(indexOfsuf);
			ps.deleteCharAt(indexOfsuf-1);
			return check();
		} else {
			return "NO";
		}
	}
}
