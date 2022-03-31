package toss;

public class Solution4 {
	public static int solution(int[][] factory) {
		boolean[] visited;
		int cnt;
		int comp = factory[0].length;
		int f = factory.length;
		// 2공장 선택
		
		// 1공장 선택
		if(f == 1) {
			return 1;
		}
		
		for (int i = 0; i < comp; i++) {
			for (int j = i + 1; j < comp; j++) {
				cnt = 0;
				visited = new boolean[f];
				
				for (int N = 0; N < f; N++) {
					if (factory[N][i] == 1) {
						visited[N] = true;
						cnt++;
					}
				}
				for (int N = 0; N < f; N++) {
					if (factory[N][j] == 1 && !visited[N]) {
						visited[N] = true;
						cnt++;
					}
				}
				
				if (cnt == f) { // 답
					return 2;
				}
			}
		}

		// 3공장 선택
		for (int i = 0; i < comp; i++) {
			for (int j = i + 1; j < comp; j++) {
				for (int k = j + 1; k < comp; k++) {
					cnt = 0;
					visited = new boolean[f];
					for (int N = 0; N < f; N++) {
						if (factory[N][i] == 1) {
							visited[N] = true;
							cnt++;
						}
					}
					for (int N = 0; N < f; N++) {
						if (factory[N][j] == 1 && !visited[N]) {
							visited[N] = true;
							cnt++;
						}
					}
					
					for (int N = 0; N < f; N++) {
						if (factory[N][k] == 1 && !visited[N]) {
							visited[N] = true;
							cnt++;
						}
					}
					
					if (cnt == f) { // 답
						return 3;
					}

				}
			}
		}

		// 4공장 선택
		for (int i = 0; i < comp; i++) {
			for (int j = i + 1; j < comp; j++) {
				for (int k = j + 1; k < comp; k++) {
					for (int l = k + 1; l < comp; l++) {
						
						cnt = 0;
						visited = new boolean[f];
						for (int N = 0; N < f; N++) {
							if (factory[N][i] == 1) {
								visited[N] = true;
								cnt++;
							}
						}
						
						for (int N = 0; N < f; N++) {
							if (factory[N][j] == 1 && !visited[N]) {
								visited[N] = true;
								cnt++;
							}
						}
						
						for (int N = 0; N < f; N++) {
							if (factory[N][k] == 1 && !visited[N]) {
								visited[N] = true;
								cnt++;
							}
						}
						
						for (int N = 0; N < f; N++) {
							if (factory[N][l] == 1 && !visited[N]) {
								visited[l] = true;
								cnt++;
							}
						}
						
						if (cnt == f) { // 답
							return 4;
						}
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(Solution4.solution(new int[][] { { 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1, 0, 0, 0, 1 },{ 1, 1, 1, 1, 0, 0, 0, 0, 0 }}));
	}
}
