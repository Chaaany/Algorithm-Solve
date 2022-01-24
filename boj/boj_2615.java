package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2615 {
	//순회탐색용 방향구분자(특정 인덱스 기준 ↗,→,↘,↓,↙,←,↖,↑을 나타냄)
	private static int[] dr = {-1, 0, 1, 1, 1, 0, -1, -1}; 
	private static int[] dc = {1, 1, 1, 0, -1, -1, -1, 0};
    
    //바둑판을 의미하는 2차원 배열
	private static String[][] go = new String[19][19]; 
    
    //연속된 바둑알을 세기 위한 counter
	private static int counter;
    
    //승리자 유무 체크용i ndex -> 0또는 1이어서 굳이 int형이 아닌 boolean형으로 처리 가능
	private static int index = 0;
	public static void main(String[] args) throws IOException {
	
    // 입력 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 19; i++) {
			go[i] = br.readLine().split(" ");
		}
	
    ///////////////////////////// 로직 부분////////////////////////////
		bkfor : for (int i = 0; i < go.length; i++) {
			for (int j = 0; j < go.length; j++) { // 좌측상단에서 우측하단으로 완전탐색
            	//흑돌 또는 백돌 탐지 시 
				if(go[i][j].equals("1") || go[i][j].equals("2")) { 
					// ↗,→,↘,↓방향 탐지시작
                    for (int k= 0;  k < 4; k++) { 
                    // 흑돌 또는 백돌 한 번 세주고 시작
                        counter=1; 
                        // 5알이 연속으로 놓여져 있을 시 && 오목이라면 그 정반대 방향 탐색(6목이상 여부 확인)
						if(check(k, go[i][j], i, j)==5 && !checkPrev(k+4 ,go[i][j], i, j)) { 
                        				//출력 기준대로 출력(배열 인덱스 + 1씩)
							System.out.printf("%s\n%d %d", go[i][j], i+1, j+1);
							index = 1; // 승리한 돌 존재 표시
							break bkfor; // 중첩 for문 탈출(완전탐색 종료)
						} 
					}
				} 
			}
		}
        	//승리한 플레이어 없음
		if(index !=1) { 
			System.out.println(0);
		}
	}
//////////////////////////////////////메서드 부분/////////////////////////////

	// 특정 바둑알 기준 특정 방향으로 5알 연속 바둑알 존재시 반대방향 탐지용(6목 이상 여부) 메서드 
	private static boolean checkPrev(int k, String player, int r, int c) {
		//바둑판 경계를 넘지 않으며 && 파라미터로 받은 방향(↙,←,↖,↑ 중 1)에 바둑알이 존재한다면 True->즉 6목 이상
        	return 0<=r+dr[k] && r+dr[k] < 19 && 0<=c+dc[k] && c+dc[k] < 19 && go[r+dr[k]][c+dc[k]].equals(player);
	}

	// 특정 방향 구분자, 돌의 색깔, 탐색 시작 지점을 파라미터로 받음
	private static int check(int k, String player , int r, int c) {
		
        if(k == 0) { //↗방향 탐색 (k==1 or 2, or 3일 때 같은 로직)
        		//바둑판 밖을 탐색하는 경우가 아니고, 해당 방향에 같은 색의 바둑돌이 존재한다면
			if (0<=r+dr[k] && r+dr[k] < 19 && 0<=c+dc[k] && c+dc[k] < 19 && go[r+dr[k]][c+dc[k]].equals(player)) {
				counter++; // 연속된 바둑알 수 ++
				check(k, player, r+dr[k], c+dc[k]); //해당 방향 계속 탐색
			} else {
            			// 바둑판 밖을 탐색하는 경우거나, 해당 방향에 바둑돌이 존재하지 않는 경우 셋던 바둑알 수 return
				return counter; 
			}
		} else if (k == 1) {//→방향 탐색
			if (0<=r+dr[k] && r+dr[k] < 19 && 0<=c+dc[k] && c+dc[k] < 19 && go[r+dr[k]][c+dc[k]].equals(player)) {
				counter++;
				check(k, player, r+dr[k], c+dc[k]);
			} else {
				return counter;
			}
		}else if (k == 2) {//↘방향 탐색
			if (0<=r+dr[k] && r+dr[k] < 19 && 0<=c+dc[k] && c+dc[k] < 19 && go[r+dr[k]][c+dc[k]].equals(player)) {
				counter++;
				check(k, player, r+dr[k], c+dc[k]);
			} else {
				return counter;
			}
		} else if (k == 3) {//↘방향 탐색
			if (0<=r+dr[k] && r+dr[k] < 19 && 0<=c+dc[k] && c+dc[k] < 19 && go[r+dr[k]][c+dc[k]].equals(player)) {
				counter++;
				check(k, player, r+dr[k], c+dc[k]);
			} else {
				return counter;
			}
		} 
		return counter;
	}
}