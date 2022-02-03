package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1654 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 10,000 이하
		int N = Integer.parseInt(br.readLine()); // 1,000,000 이하
		long[] arr = new long[K];
		long sum = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

	}
}
