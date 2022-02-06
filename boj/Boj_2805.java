package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int[] trees = new int[N];
		int min = 0;
		int max = 0;
		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(stz.nextToken());
			max = max < trees[i] ? trees[i] : max;
		}

		while (min < max) {

			int mid = (min + max) / 2;
			long sum = 0;
			for (int j : trees) {
				sum = j - mid > 0 ? sum + j - mid : sum;
			}

			if (sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);

	}
}
