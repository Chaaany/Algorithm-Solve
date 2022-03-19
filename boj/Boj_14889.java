package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
	static int N, abilityTable[][], min, total;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		min = Integer.MAX_VALUE;
		abilityTable = new int[N + 1][N + 1]; // 0행, 0열은 padding
		total = 0;
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				abilityTable[i][j] = Integer.parseInt(stz.nextToken());
				total += abilityTable[i][j];
			}
		}
		
		// 1. 사람 조합 n C (n/2) / 2만큼의 갯수만큼 nCr돌리기/
		visited = new boolean[N + 1]; // 특정 팀원 팀 꾸려진 경우
		nCr(0, 0);
		System.out.println(min);

	}

	private static void nCr(int cnt, int start) {
		if (cnt > 0 && !visited[1])
			return; // 첫 번째가 1인 경우가 아닐 경우 어차피 겹침 ex 1 3 4 / 2 5 6 = 2 5 6 / 1 3 4

		if (cnt == N / 2) { // N/2명 확정시 나머지 N/2명도 확정
			int team1 = synergy();
			min = Math.min(min, Math.abs((total - team1) - team1));
			return;
		}

		for (int i = start; i <= N; i++) { // N명으로 for문 순회
			visited[i] = true;
			nCr(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

	private static int synergy() {
		int[] team = new int[N / 2];
		int index = 0;
		int synergy = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				team[index++] = i;
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				synergy += abilityTable[team[i]][team[j]] + abilityTable[team[j]][team[i]];
			}
		}

		return synergy;
	}

}
