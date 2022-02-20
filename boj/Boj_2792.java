package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2792 {
	static int studentCnt, jewelCnt, min, max, jewel[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());

		studentCnt = Integer.parseInt(stz.nextToken());
		jewelCnt = Integer.parseInt(stz.nextToken());
		min = Integer.MAX_VALUE;
		max = -1;
		jewel = new int[jewelCnt];
		
		for (int i = 0; i < jewel.length; i++) {
			jewel[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, jewel[i]);
		}

		check(1, max);

		System.out.print(min);

	}

	private static void check(int low, int high) {
		int left = low;
		int right = high;

		while (left <= right) {
			int mid = (left + right) / 2;
			int tempCnt = 0;
			
			for (int i : jewel) {
				tempCnt += (int)Math.ceil((i*1.0) / (mid*1.0));
			}

			if (tempCnt > studentCnt) {
				left = mid + 1;
			} else {
				right = mid - 1;
				min = Math.min(min, mid);
			}
		}
		
		
	}
}
