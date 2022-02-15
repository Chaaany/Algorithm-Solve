package boj;

/* 
    도영이가 만든 맛있는 음식
*/

import java.io.*;
import java.util.*;

public class Boj_2961_비트마스킹 {
	static int N;
	static int[][] taste;
	static int diff;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		taste = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}

		diff = 1000000000;

		subSet(0, 0, 1, 0);

		System.out.println(diff);
	}

	static void subSet(int cnt, int bit, int sour, int bitter) {

		if (cnt == N) {

			if (bit == 0) { // 아무 것도 선택하지 않았음 
				return;
			}

			diff = Math.min(diff, Math.abs(sour - bitter));

			return;
		}

		subSet(cnt + 1, bit, sour, bitter);
		subSet(cnt + 1, bit | (1 << cnt), sour * taste[cnt][0], bitter + taste[cnt][1]);

	}

}