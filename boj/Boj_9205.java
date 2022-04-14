package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9205 {
	static int T, n, loc[][];
	static boolean visited[];
	static Queue<int[]> q;
	static String answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//1. 출발은 상근이네 집에서 하고, 맥주 한 박스를 들고 출발한다
		//2. 맥주 한 박스에는 맥주가 20개 들어있다. 
		//3. 목이 마르면 안되기 때문에 50미터에 한 병씩 마시려고 한다. 즉, 50미터를 가려면 그 직전에 맥주 한 병을 마셔야 한다. -> 1,000 이내에 편의점이 있어야함
		//4. 편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다. 하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없다.
		//5. 편의점을 나선 직후에도 50미터를 가기 전에 맥주 한 병을 마셔야 한다.
		//6. 테스트 케이스의 수 <= 50, 0 <= 맥주를 파는 편의점의 갯수 <= 100
		//7. 집, 편의점, 페스티벌 좌표 각각  -32768 <= x, y <= 32767(short형 정도)
		//8. 좌표 사이의 거리는 맨해튼 거리다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			answer = "sad";
			loc = new int[n+2][3]; // 1번 인덱스 x 좌표, 2번 인덱스 y좌표, 3번인덱스 현재 위치에서의 거리
			visited = new boolean[n+2];
			for (int j = 0; j < n+2; j++) {
				stz = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stz.nextToken());
				int y = Integer.parseInt(stz.nextToken());
				int distance = Math.abs(loc[0][0] - x) + Math.abs(loc[0][1] - y);
				loc[j][0] = x;
				loc[j][1] = y;
				loc[j][2] = distance;
			}
			
			
			q = new LinkedList<>();
			visited[0] = true; //방문처리
			q.add(loc[0]); // 큐에 넣기
			
			bfs();
			
			sb.append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	private static void bfs() {
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			if(x == loc[n+1][0] && y == loc[n+1][1]) {
				answer = "happy";
				return;
			}
			for (int i = 0; i < loc.length; i++) {
				if(visited[i])continue; // 이미 방문했니?
				
				int toVisitLocX = loc[i][0]; 
				int toVisitLocY = loc[i][1];
				int distance = Math.abs(toVisitLocX - x)+ Math.abs(toVisitLocY - y);
				
				if(distance <= 1000) { // 방문 가능
					q.add(new int[] {toVisitLocX, toVisitLocY});
					visited[i] = true;
				}
			}
		}
	}
}
