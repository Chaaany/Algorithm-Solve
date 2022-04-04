package toss;

import java.util.ArrayList;
import java.util.List;

public class Solution8 {
	static boolean visited[], chk;
	static int nums[];
	static int n;
	static List<int[]> l = new ArrayList<>();
	public static int[][] solution(int[][] dist) {
		n = dist.length;
		visited = new boolean[n];
		nums = new int[n];
		dfs(0, dist);
		int[][] answer = new int[l.size()][n];
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				answer[i][j] = l.get(i)[j];
			}
		}
		
		return answer;
	}

	private static void dfs(int cnt, int[][] dist) {
		
		if(cnt == n) {
			check(dist);
			return;
		}
		
		for (int i = 0; i < dist.length; i++) {
			if(visited[i]) continue;
			
			nums[cnt] = i;
			visited[i] = true;
			dfs(cnt+1, dist);
			
			visited[i] = false;
		}
		
	}

	private static void check(int[][] dist) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if(dist[nums[i]][nums[j]] + dist[nums[j]][nums[k]] != dist[nums[i]][nums[k]]) {
						return;
					};
				}
			}
		}
		l.add(nums);
		
	}

	public static void main(String[] args) {
		int ans1 = Solution8.solution(8, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 0 }, { 5, 1 }, { 6, 1 },
				{ 7, 2 }, { 7, 3 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }, 4, 0, 3);
		System.out.println(ans1);
	}
}
