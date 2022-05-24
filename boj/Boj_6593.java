package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 아이디어 최단거리 구하기
// 최단거리? -> bfs
// 근데 3차원? 해봤자 상, 하 델타만 더 넣어주면 됨
// 끝


public class Boj_6593 {
	// 동,서,남,북,상,하 delta필요함
	// delta[][] = { {0,-1},{0,1}};
	// delta[][] = { {-1,0},{1,0}};
	
	static int delta[][] = { { 0, 0, 1 }, { 0, 0, -1 }, { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 } }, L, R, C,
			start[], end[], answer;
	
	static String buildingMap[][][];
	
	static boolean chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			chk = false;
			stz = new StringTokenizer(br.readLine());
			L = Integer.parseInt(stz.nextToken());
			R = Integer.parseInt(stz.nextToken());
			C = Integer.parseInt(stz.nextToken());
			if(L == 0 && R ==0 && C == 0)break; // 0 0 0 들어왔으면 끝냄
			
			buildingMap= new String[L + 2][R + 2][C + 2]; // 패딩해서 경계값 체크 없앰
			
			//배열 초기화
			for(int i = 0; i <= L+1; i++) {
				for(int j = 0; j <= R+1; j++) {
					for(int k = 0; k <= C + 1 ; k++) {
						buildingMap[i][j][k] = "0";
					}
				}
			}
			
			
			//빌딩 지도 완성
			for (int i = 1; i <= L; i++) {
				for (int j = 1; j <= R; j++) {
					
					String temp[] = br.readLine().split("");
					
					for (int k = 1; k <= C; k++) {
						buildingMap[i][j][k] = temp[k - 1];
						
						if (buildingMap[i][j][k].equals("S")) { // 시작점 체크
							start = new int[] { i, j, k };
						} else if (buildingMap[i][j][k].equals("E")) {
							end = new int[] { i, j, k };
						}
					}
				}
				br.readLine();// 빈행 버리기
			}
			
			buildingMap[start[0]][start[1]][start[2]] = "0"; // 시작점 체크
			
			bfs(); // bfs 시작
			
			//해당 빌딩 답 저장
			if(chk) {
				sb.append("Escaped in ").append(answer).append(" minute(s).\n");
			}else {
				sb.append("Trapped!").append("\n");
			}

		}
		sb.setLength(sb.length()-1);
		
		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			
			int l = temp[0];
			int r = temp[1];
			int c = temp[2];
			
			for (int i = 0; i < delta.length; i++) {
				int nl = l + delta[i][0];
				int nr = r + delta[i][1];
				int nc = c + delta[i][2];

				
				// 도착점 만났을 때 
				if(nl == end[0] && nr == end[1] && nc == end[2]){
					answer = (Integer.parseInt(buildingMap[l][r][c]) +1);
					chk = true;
					return;
				}

				// 갈 수 있는 곳이 아닐 때
				if(!(buildingMap[nl][nr][nc].equals(".")))continue;
				
				// 출발점으로부터 최단거리 지정 
				buildingMap[nl][nr][nc] = String.valueOf((Integer.parseInt(buildingMap[l][r][c]) +1));
				
				q.add(new int[] {nl, nr, nc});
			}
		}
	}
}