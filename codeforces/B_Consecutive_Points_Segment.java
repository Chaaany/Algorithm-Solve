package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Consecutive_Points_Segment {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int N;
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			boolean chk = false;
			N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			boolean change = false;
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(stz.nextToken());
				if (j != 0) {
					// 이전에 들어온 수랑 차이가 2일 경우
					if (arr[j] - arr[j - 1] == 2) {
						arr[j]--;
					} else if (arr[j] - arr[j - 1] == 3) {
						if (change) {
							sb.append("NO\n");
							chk = true;
							break;
						} else {
							arr[j]--;
							change = true;
						}
					} else if (arr[j] - arr[j - 1] > 3) { // 더 클 경우 못움직임
						sb.append("NO\n");
						chk = true;
						break;
					}
				}

			}
			if (!chk) {

				sb.append("YES\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}