package toss;


public class Solution7 {
	static int arr[][], answerArr[][];
	static int nums[];
	static int tempArr;
	static boolean[] visited;
    public static int solution(int n, int[][] edges, int k, int a, int b) {
        
    	int answer = -1;
        
        // 2 <= 송전탑 갯수 <= 16
        // n-1 <= edges <= min(50, n(n-1)/2)
        // a -> b로가는데 k이하로 갈 수 있는 간선 찾기
        // 찾은 후 포함되지 않는 간선은 지워버리기-> 지워버린 후 답
        arr = new int[n][n]; // 패딩
        answerArr = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
        	arr[from][to] = 1;
        	arr[to][from] = 1;
        	// 간선 연결
		}
        tempArr = 0;
        visited = new boolean[n];
        nums = new int[k+1];
        visited[a] = true;
        nums[0] = a;
        int cnt = 0;
        dfs(a, b, 1, k, n);
        for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			if(answerArr[from][to] != 0 || answerArr[to][from] != 0 ) {
				cnt++;
			}
		}
        answer = cnt;
        
        return answer;
    }
	private static void dfs(int a, int b, int count, int targetN, int NodeN) {
		// 간선 갯수 초과하면 return
		if(count != 1 && arr[nums[count-2]][nums[count-1]] == 0) return;
		
		if(count == targetN+1 && nums[count-1] == b) {
			tempArr++;
			for (int i = 1; i < count; i++) {
				answerArr[nums[i-1]][nums[i]]++;
			}
			return;
		}
		
		if(count == targetN+1 && nums[count-1] != b)return;
		
		// 간선 연결 안되어 있으면 return;
		
		if(nums[count-1] == b) {
			tempArr++;
			for (int i = 1; i < count; i++) {
				answerArr[nums[i-1]][nums[i]]++;
			}
			return;
		}
		
		for (int i = 0; i < NodeN; i++) {
			if(visited[i]) continue;
			
			nums[count] = i;
			visited[i] = true;
			dfs(a, b, count+1, targetN, NodeN);
			visited[i] = false;
		}
		
	}
	public static void main(String[] args) {
		int ans1 = Solution7.solution(8, new int[][]{{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}}, 4, 0, 3);
		System.out.println(ans1);
	}
}
