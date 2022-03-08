package prog;

import java.util.HashSet;

class Solution1 {
	static int ans = 0;
	static int set[];

	public int solution(int n, int[][] computers) {
		int answer = 0;
		set = new int[n];
		makeSet(n);
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1)
					Union(i, j);
			}
		}
		for (int i = 0; i < set.length; i++) {
			hs.add(set[i]);
		}
		if (hs.isEmpty()) {
			return 0;
		} else {
			answer = hs.size();
			return answer;
		}
	}

	private static void Union(int i, int j) {
		int tempI = find(i);
		int tempJ = find(j);
		if (tempI == tempJ)
			return;
		set[tempJ] = set[tempI];
	}

	private static int find(int i) {
		if (i == set[i])
			return set[i];

		return set[i] = find(set[i]);
	}

	private static void makeSet(int n) {
		for (int i = 0; i < n; i++) {
			set[i] = i;
		}
	}
}
