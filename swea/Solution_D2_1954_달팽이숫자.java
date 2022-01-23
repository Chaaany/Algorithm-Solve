package swea;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 0;
		int[][]	map;
		int N = 0;
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			map=new int[N][N];
			int r = 0;
			int c = 0;
			int d = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[r][c]=i*N+j+1;
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]!=0) {
						d = (d+1)%4;
					}
					r+= dr[d];
					c+= dc[d];
				}

			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
