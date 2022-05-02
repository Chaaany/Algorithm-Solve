package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Boj_6549 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1 <= 직사각형의 수 <= 100,000
		// 0 <= 직사각형의 높이 < 1,000,000,000
		// 시간제한 1초 - 1억번 연산 가ㅡ능
		// 무조건 특정 직사각형 높이 x n개가 답일 수 밖에 없음
		// 2 1 4 5 1 3 3
		// 2 2 4 8 8 8 8
		// n 또는 nlogn의 시간 복잡도
		// 7 2 1 4 5 1 3 3
		// 7 7 7 7 8 8 8 8
		// 높이별 인덱스를 저장해두기
		// 특정 높이 보다 높은 경우만 찾아서 최댓값 갱신
		LinkedHashSet<Long> lhs = new LinkedHashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[];
		StringBuilder sb = new StringBuilder();
		while (true) {
			str = br.readLine().split(" ");
			if (str.length == 1 && Integer.parseInt(str[0]) == 0)
				break;
			long arr[] = new long[str.length];
			for (int i = 0; i < str.length; i++) {
				arr[i] = Long.parseLong(str[i]);
				lhs.add(arr[i]);
			}
			long answer = 0L;
			for (long height : lhs) {
				int max = 0;
				int cnt = 0;
				for (int j = 0; j < arr.length; j++) {
					if (height <= arr[j]) {
						cnt++;
					} else {
						max = Math.max(cnt, max);
						cnt = 0;
					}
				}
				
				answer = Math.max(Math.max(cnt, max) * height, answer);
				
			}
			
			sb.append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
