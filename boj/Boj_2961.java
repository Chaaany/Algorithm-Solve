package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2961 {

	static int N;
	static int[][] taste;
	static int diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(stz.nextToken());
			taste[i][1] = Integer.parseInt(stz.nextToken());
		}

		diff = Integer.MAX_VALUE;
		subset(0, 1, 0);
		System.out.println(diff);
	}

	private static void subset(int cnt, int sour, int bitter) {
		if (cnt == N) {
			if (bitter == 0 || sour == 1) {
				return;
			}
			diff = Math.min(diff, Math.abs(sour - bitter));
			return;
		}

		subset(cnt + 1, sour * taste[cnt][0], bitter + taste[cnt][1]);
		subset(cnt + 1, sour, bitter);
	}
}
