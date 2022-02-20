package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {
	static int T, N, arr[], nums[], count;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			count = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			nums = new int[N];
			stz = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(stz.nextToken());
			}

			perm(0, 0);

			sb.append("#" + t + " " + count + "\n");
		}
		System.out.print(sb);
	}

	private static void perm(int cnt, int flag) {
		if (cnt == N) {
			subset(0, 0, 0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			nums[cnt] = arr[i];
			perm(cnt + 1, flag | 1 << i);
		}

	}

	private static void subset(int cnt, int leftTotal, int rightTotal) {
		if (leftTotal < rightTotal)
			return;

		if (cnt == N) {
			count++;
			return;
		}

		subset(cnt + 1, leftTotal + nums[cnt], rightTotal);
		subset(cnt + 1, leftTotal, rightTotal + nums[cnt]);
	}

}
