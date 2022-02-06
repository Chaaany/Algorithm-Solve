package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj_2108 {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dividend = 0;
		arr = new int[N];
		int max = 0;
		long sum = 0;
		Map<Integer, Integer> l = new HashMap<>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

			if (l.containsKey(arr[i])) {
				l.put(arr[i], l.get(arr[i]) + 1);
			} else {
				l.put(arr[i], 1);
			}
			sum += arr[i];
		}
//		1. 산술평균 : 평균
		System.out.println(Math.round((double)sum / (double)N));
//		2. 중앙값
		Arrays.sort(arr);
		System.out.println(arr[N / 2]);
//		3. 최빈값
		List<Integer> answer = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			max = max < l.get(arr[i]) ? l.get(arr[i]) : max;
		}
		for (int i = 0; i < N; i++) {
			if(l.get(arr[i]) == max) {
				l.put(arr[i], 0);
				answer.add(arr[i]);
			}
		}

		if (answer.size() == 1) {
			System.out.println(answer.get(0));
		} else {
			Collections.sort(answer);
			System.out.println(answer.get(1));
		}
//		4. 범위
		Arrays.sort(arr);
		System.out.println(arr[N - 1] - arr[0]);
	}
}
