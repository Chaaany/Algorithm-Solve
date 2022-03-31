package bucketplace;

public class Solution2 {//17분소요

	public static long solution(int[][] beds, int[][] tables, int cost) {
		long answer = Long.MAX_VALUE;
		System.out.println();
		for (int i = 0; i < beds.length; i++) {
			int bedsA = beds[i][0];
			int bedsB = beds[i][1];
			int bedPrice = beds[i][2];
			for (int j = 0; j < tables.length; j++) {
				int tableA = tables[j][0];
				int tableB = tables[j][1];
				int tablePrice = tables[j][2];
				// a+c 
				int H = bedsA + tableA;
				int W = Math.max(bedsB, tableB);
				
				int price = bedPrice + tablePrice + (H*W)*cost; 
				answer = Math.min(answer, price);
				
				// a+ d
				H = bedsA + tableB;
				W = Math.max(bedsB, tableA);
				price = bedPrice + tablePrice + (H*W)*cost; 
				answer = Math.min(answer, price);
				
				// b+ c
				H = bedsB + tableA;
				W = Math.max(bedsA, tableB);
				price = bedPrice + tablePrice + (H*W)*cost; 
				answer = Math.min(answer, price);
				
				// b+ d
				H = bedsB + tableB;
				W = Math.max(bedsA, tableA);
				price = bedPrice + tablePrice + (H*W)*cost; 
				answer = Math.min(answer, price);
			}
		}
		
		return answer;
    }

	public static void main(String[] args) {
		System.out.println(Solution2.solution(new int[][]{{4, 1, 200000}}, new int[][] {{2, 3, 100000}}, 10000));
		System.out.println(Solution2.solution(new int[][]{{2, 3, 40}, {2, 5, 20}}, new int[][] {{1, 1, 30}}, 10000));
		System.out.println(Solution2.solution(new int[][]{{2, 3, 40000}, {2, 5, 20000}}, new int[][] {{1, 1, 30000}}, 10));

	}
}
