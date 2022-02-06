package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_18111 {
	static int[][] ground;
	static int N, M, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		B = Integer.parseInt(stz.nextToken());
		ground = new int[N][M];
		int min = Integer.MAX_VALUE, max = -1, sum = 0, mid = 0;
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(stz.nextToken());
				min = Math.min(min, ground[i][j]);
				max = Math.max(max, ground[i][j]);
			}
		}

		int minTime = 987654321;
		int maxGround = 0;
		for (int i = min; i <= max; i++) {
			int time = 0;
			int tempB = B;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (ground[j][k] - i >= 0) {
						tempB += ground[j][k] - i;
						time += (ground[j][k] - i) * 2;
					} else {
						tempB += ground[j][k] - i;
						time += (ground[j][k] - i) * -1;
					}
				}
			}
			if (tempB >= 0) {
				if (time <= minTime) {
					minTime = time;
					maxGround = i;

				}
			}
		}
		System.out.println(minTime + " " + maxGround);
	}
}
