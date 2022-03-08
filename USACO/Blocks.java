package USACO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Blocks {
	static String arr[], in[], temp[];
	static StringBuilder sb;
	static boolean chk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		arr = new String[4];
		int N = Integer.parseInt(br.readLine());
		in = new String[N];
		for (int i = 0; i < 4; i++) {
			arr[i] = br.readLine().trim();
		}

		for (int i = 0; i < N; i++) {
			chk = false;
			in[i] = br.readLine().trim();
			temp = new String[in[i].length()];
			nPr(0, in[i].length(), new boolean[4], in[i]);
			if (i != N - 1) {
				if (chk) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			} else {
				if (chk) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
			}
			;
		}

		System.out.println(sb);

	}

	private static void nPr(int cnt, int N, boolean[] visited, String test) {
		if (cnt == N) {
			check(temp, test);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			temp[cnt] = arr[i];
			nPr(cnt + 1, N, visited, test);
			visited[i] = false;

		}
	}

	private static void check(String[] temp, String test) {
		for (int i = 0; i < test.length(); i++) {
			if (temp[i].indexOf(String.valueOf(test.charAt(i))) == -1)
				return;
		}
		chk = true;
	}
}
