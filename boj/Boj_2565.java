package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2565 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 전깃줄 최소로 없애서 교차하지 않게 만들기
		// 1 <= 전깃줄 갯수 <=100, 1 <= 위치의 번호 <= 500 -> boolean 배열선언 최대 boolean[500][500]
		// boolean으로 해도 됨.
		// 같은 위치에 두 개 이상 전깃줄 X
		// 특정 전깃줄이 엮여 있는 갯수를 각각 넣어둬야 할까?
		// 정렬을 해보자

		int arr[][];
		int dp[] = new int[501]; // 겹치는 줄 갯수 넣는 dp;
		int N;
		StringTokenizer stz;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][3]; // 전깃줄 배열 저장
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			arr[i] = new int[] { from, to, 1 };
		}
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
	

		for (int i = 1; i <= N; i++) {
			for (int j = i; j >= 0; j--) {
				if(arr[i][1] > arr[j][1]) { 
					arr[i][2] = Math.max(arr[i][2], arr[j][2]+1);
				}
			}
			answer = Math.max(arr[i][2], answer);
		}


		System.out.println(N - answer);

	}
}
