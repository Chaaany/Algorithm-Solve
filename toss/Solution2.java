package toss;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 { // 23분소요
	
    public static int[] solution(int[][] contests, int k, int p) {
        int[] answer = new int[k];
        
        int[][] arr = contests; 
        int my = p;
        int tempAns[][] = new int[arr.length][2]; // 대회 갯수만큼 배열 선언
        
        for (int i = 0; i < tempAns.length; i++) {
			tempAns[i][0] = i;
		}
        
        for (int i = 0; i < arr.length; i++) { // 대회 갯수만큼 돎
			for (int j = 0; j < arr[i].length; j++) {
				if(my>= arr[i][j]) {
					tempAns[i][1]++;
				}
			}
		}
        
		Arrays.sort(tempAns, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o2[1] - o1[1];
			}
		});
        
        for (int i = 0; i < k; i++) {
        	answer[i] = tempAns[i][0];
		}
        
        Arrays.sort(answer);
        
        return answer;
    }
	
	
	
	
	
	
	public static void main(String[] args) {
		int[] an = Solution2.solution(new int[][]{{1, 5, 2, 3}, {9, 9, 9, 9}, {1, 9, 3, 9}, {4, 3, 2, 1}}, 3, 4 );
		
		
	}
}
