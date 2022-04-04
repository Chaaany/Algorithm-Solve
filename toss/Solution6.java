package toss;

import java.util.Arrays;

public class Solution6 {//17분소요
	static char[] chArr = {'a','b','c'};
	static int nums[], preArr[][];
	static int count;
	static int chCount[];
	static int chtempCount;
	static char[][] arr;
	static int[][] delta = {{-1,0},{1,0}, {0,-1},{0,1}};
	static char[][] tempArr;
	static int tempAnswer;
    public static int solution(String[] grid) {
    	tempAnswer = 0;
        int answer = -1;
        arr = new char[grid.length][];
        preArr = new int[10][2];
        
        for (int i = 0; i < grid.length; i++) {
        	arr[i] = grid[i].toCharArray();
		}
        count = 0;
        for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == '?') {
					preArr[count][0] = i;
					preArr[count][1] = j;
					count++;
				}
			}
		}
        
        nums = new int[count];
        
        subSet(0);
        
        answer = tempAnswer;
        
        return answer;
    }
	private static void subSet(int cnt) {
		if(cnt == count){
			check();
			return;
		}
		
		nums[cnt] = 0;
		subSet(cnt+1);
		
		nums[cnt] = 1;
		subSet(cnt+1);
		
		nums[cnt] = 2;
		subSet(cnt+1);
		
	}
	private static void check() {
		chtempCount = 0;
		boolean visited[] = new boolean[3];
		tempArr = new char[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = Arrays.copyOf(arr[i], arr[i].length); 
		}
		for (int i = 0; i < chArr.length; i++) {
			for (int j = 0; j < count; j++) {
				int r =  preArr[j][0];
				int c =  preArr[j][1];
				tempArr[r][c] = chArr[nums[j]];
			}
		}
		// 돌면서 다 연결되어 있는지 확인
		for (int i = 0; i < tempArr.length; i++) {
			for (int j = 0; j < tempArr[i].length; j++) {
				if(tempArr[i][j] == 'a' && !visited[0]) {
					dfs(i, j, 'a');
					visited[0] = true;
				}else if(tempArr[i][j] == 'b' && !visited[1]) {
					dfs(i, j, 'b');
					visited[1] = true;
				}else if(tempArr[i][j] == 'c' && !visited[2]) {
					dfs(i, j, 'c');
					visited[2] = true;
				}
				
			}
		}
		
		if(chtempCount == tempArr.length * tempArr[0].length) {
//			System.out.println(tempAnswer);
			tempAnswer++;
		}
	}
	private static void dfs(int r, int c, char i) {
		if(tempArr[r][c] != i) return;
		
		tempArr[r][c] = 0;
		chtempCount++;
		
		for (int k = 0; k < 4; k++) {
			int nr = r + delta[k][0]; 
			int nc = c + delta[k][1];
			if(!check(nr, nc)) continue;
			dfs(nr, nc, i);
		}
	}
	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < arr.length && 0 <= nc && nc < arr[0].length;
	}
	public static void main(String[] args) {
		int ans1 = Solution6.solution(new String[] {"??b", "abc", "cc?"});
		int ans2 = Solution6.solution(new String[] {"abcabcab","????????"});
		int ans3 = Solution6.solution(new String[] {"aa?"});
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
	}
}
