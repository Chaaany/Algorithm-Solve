package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = Integer.parseInt(stz.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1]  - o2[1];
			}
		});
		
		int lastTime = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if(lastTime <= arr[i][0]) {
				lastTime = arr[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
}
