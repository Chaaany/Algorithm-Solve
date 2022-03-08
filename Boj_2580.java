import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2580 {
	static int map[][], checkList[][], targetCnt;
	static boolean squareVisited[][], rowVisited[][], columnVisited[][];
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		checkList = new int[81][2];
		squareVisited = new boolean[10][10];
		rowVisited = new boolean[10][10];
		columnVisited = new boolean[10][10];
		
		map = new int[10][10];
		for (int i = 1; i < 10; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				if(map[i][j] != 0) {
					rowVisited[i][map[i][j]] = true; // 행 확인
					columnVisited[j][map[i][j]] = true; // 열 확인
					checkVisitSquare(i, j, map[i][j]);
				} else {
					checkList[targetCnt][0] = i;
					checkList[targetCnt++][1] = j;
				}
			}
		}
		check(0);
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void check(int cnt) {
		if(cnt == targetCnt)
			return;
		
		int r = checkList[cnt][0];
		int c = checkList[cnt][1];
		int tempR = (r-1) / 3;
		int tempC = (c-1) / 3 ;
		int squarePosition = tempR *3 + tempC + 1;
		
		for (int i = 1; i <= 9; i++) {
			if(rowVisited[r][i] || columnVisited[c][i] || squareVisited[squarePosition][i])continue;
			
			rowVisited[r][i] = true;
			columnVisited[c][i] = true;
			squareVisited[squarePosition][i] = true;
			map[r][c] = i;
			check(cnt+1);
			rowVisited[r][i] = false;
			columnVisited[c][i] = false;
			squareVisited[squarePosition][i] = false;
		}
			
	}
	private static void checkVisitSquare(int r, int c, int value) {
		int tempR = (r-1) / 3;
		int tempC = (c-1) / 3 ;
		int squarePosition = tempR *3 + tempC + 1;
		squareVisited[squarePosition][value] = true;
	}
}
