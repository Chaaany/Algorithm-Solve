package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int T = Integer.parseInt(br.readLine());
		int oneCoin = 0, twoCoin = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			stz = new StringTokenizer(br.readLine());
			oneCoin = Integer.parseInt(stz.nextToken());
			twoCoin = Integer.parseInt(stz.nextToken());
			if(oneCoin == 0) {
				sb.append(1).append("\n");
			}else {
				sb.append(1*oneCoin + 2*twoCoin+1).append("\n");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
