package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_StringBuilding {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String arr[] = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			arr = br.readLine().split("");
			boolean chk = false;
			if (arr.length == 1) {
				sb.append("NO\n");
				chk = true;
			} else {
				String temp = arr[0];
				int cnt = 1;
				for (int j = 1; j < arr.length; j++) {
					if (temp.equals(arr[j])) {
						cnt++;
					} else {
						if (cnt == 1) {
							sb.append("NO\n");
							chk = true;
							break;
						} else {
							cnt = 1;
							temp = arr[j];
							if(j == arr.length-1) {
								sb.append("NO\n");
								chk = true;
								break;
							}
						}
					}
				}
			}
			if (!chk)
				sb.append("YES\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);

	}
}
