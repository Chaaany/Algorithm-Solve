package sk_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test4 {
	static int arr[][], cnt, nums[], count, tempN, ans;
	static HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

	public long solution(int n, int[][] edges) {
		long answer = 0;
		tempN = n;
		arr = new int[n][n];
		nums = new int[3];

		for (int i = 0; i < edges.length; i++) { // 노드 간선 연결
			ArrayList<Integer> temp1 = new ArrayList<>();
			if (hm.get(edges[i][0]) != null) {
				temp1 = hm.get(edges[i][0]);
				temp1.add(edges[i][1]);
				hm.put(edges[i][0], temp1);
			} else {
				temp1.add(edges[i][1]);
				hm.put(edges[i][0], temp1);
			}
			ArrayList<Integer> temp2 = new ArrayList<>();
			if (hm.get(edges[i][1]) != null) {
				temp2 = hm.get(edges[i][1]);
				temp2.add(edges[i][0]);
				hm.put(edges[i][1], temp2);
			} else {
				temp2.add(edges[i][0]);
				hm.put(edges[i][1], temp2);
			}

		}

		perm(0, new boolean[n]); // 숫자 순열 찾기
		answer = ans;

		return answer;
	}

	private void perm(int cnt, boolean[] visited) {

		if (cnt == 3) {
			if (check())
				ans++;
			return;
		}

		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				continue;

			nums[cnt] = i;
			visited[i] = true;
			perm(cnt + 1, visited);
			visited[i] = false;
		}
	}

	private boolean check() {
		return distance(nums[0], nums[2]) == (distance(nums[0], nums[1]) + distance(nums[1], nums[2]));
	}

	private int distance(int i, int j) {
		count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		bfs(j, q, new boolean[tempN]);
		return count;

	}

	private void bfs(int j, Queue<Integer> q, boolean[] visited) {
		if (q.isEmpty())
			return;
		count++;
		Queue<Integer> nextQ = new LinkedList<>();
		while (!q.isEmpty()) {
			int temp = q.poll();
			List<Integer> tempL = hm.get(temp);
			for (Integer integer : tempL) {
				if (visited[integer])
					continue;
				if (integer == j)
					return;
				visited[integer] = true;
				nextQ.add(integer);
			}
		}
		bfs(j, nextQ, visited);

	}

	public static void main(String[] args) {
		Test4 t = new Test4();

		System.out.println(t.solution(5, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 } }));
	}
}
