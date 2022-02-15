package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_10972 {
	static int N, input[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		input = new int[N];
		
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stz.nextToken());
		}

		// 1. 오름차순 정렬

		if (np()) {
			System.out.println(Arrays.toString(input).replaceAll(",", "").replace("[", "").replace("]", ""));
		} else {
			System.out.println(-1);
		}
	}

	private static boolean np() {

		// 1. 교환위치 찾기
		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i])
			--i;

		if (i == 0)
			return false;

//		 2. 교환위치에 교환할 값 찾기
		int j = N - 1;
		while (input[i - 1] >= input[j])
			--j;

		// 3. 교환위치와 교환할 값 교환하기
		swap(i - 1, j);

		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순 정렬)
		int k = N - 1;

		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
