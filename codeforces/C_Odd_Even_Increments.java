package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_Odd_Even_Increments {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			int arr[] = new int[N];

			stz = new StringTokenizer(br.readLine());
			boolean chk = false;
			int evenCnt = 0;
			int oddCnt = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(stz.nextToken());
				if ((arr[j] & 1) == 1) {
					oddCnt++;
				} else {
					evenCnt++;
				}
			}
			if (oddCnt == arr.length || evenCnt == arr.length) {
				sb.append("YES\n");
			} else {
				for (int j = 0; j < N; j++) {
					if (j != 0) {
						if ((arr[j] & 1) == (arr[j - 1] & 1)) {
							chk = true;
							sb.append("NO\n");
							break;
						}
					}
				}
				if (!chk)
					sb.append("YES\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
