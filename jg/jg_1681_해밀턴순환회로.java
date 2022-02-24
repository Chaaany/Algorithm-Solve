package jg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jg_1681_해밀턴순환회로 {
	static int map[][], start, N, nums[], min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		start = 1;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N + 1][N + 1];
		nums = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		nums[0] = 1; // 시작 1
		nums[N] = 1; // 끝 1

		npr(1, new boolean[N + 1], 0); //
		System.out.println(min);

	}

	private static void npr(int cnt, boolean[] visited, int total) {
		if (total >= min)
			return;

		if (cnt == N) { // 이미 첫번째, 마지막 인덱스는 넣어져있음
			if (total != total + map[nums[cnt - 1]][nums[cnt]]) {
				min = Math.min(min, total + map[nums[cnt - 1]][nums[cnt]]);
			}
			return;
		}

		for (int i = 2; i <= N; i++) {
			if (visited[i])
				continue;

			nums[cnt] = i;
			if (total == total + map[nums[cnt - 1]][nums[cnt]])
				continue;
			visited[i] = true;
			npr(cnt + 1, visited, total + map[nums[cnt - 1]][nums[cnt]]);
			visited[i] = false;
		}
	}

}
