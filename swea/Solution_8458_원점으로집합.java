package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458_원점으로집합 {
	static int T, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int temp = 0;
			int evenCnt = 0;
			int oddCnt = 0;
			int max = -1;
			for (int i = 0; i < N; i++) { // 맨해튼 거리로 받기
				stz = new StringTokenizer(br.readLine());
				temp += Math.abs(Integer.parseInt(stz.nextToken()));
				temp += Math.abs(Integer.parseInt(stz.nextToken()));
				max = Math.max(temp, max);
				if (temp % 2 == 0)
					evenCnt++;
				else
					oddCnt++;
			}
			if (evenCnt * oddCnt != 0) {
				sb.append("#").append(t).append(" ").append(-1).append("\n");
			} else {
				int index = 0;
				while (max != 0) {
					if (max > index) {
						max -= index;
					} else if (max == index) {
						// 거리가 index와 같을 때
						max = 0;
					} else {
						// 거리가 index보다 작을 때
						max = index - max;
						if (max % 2 == 0) { // index에서 거리 뺀 값이 짝수 일 때
							max = 0;
						} else { // 홀수일 때
							max = 1;
						}
					}
					index++;
				}
				sb.append("#").append(t).append(" ").append(index).append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
