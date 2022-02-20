package boj;

//import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4963 {
	static int arr[][], w, h, count;
	static int delta[][] = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;

		StringBuilder sb = new StringBuilder();

		while (true) {
			stz = new StringTokenizer(br.readLine());
			w = Integer.parseInt(stz.nextToken());
			if (w == 0)
				break;

			h = Integer.parseInt(stz.nextToken());
			count = 0;
			arr = new int[h + 2][w + 2]; // 패딩
			for (int i = 1; i <= h; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 1; j <= w; j++) {
					arr[i][j] = Integer.parseInt(stz.nextToken());
				}
			}
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (arr[i][j] == 1) {
//						dfs(i, j);
						bfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}

	private static void bfs(int r, int c) {
//		Queue<Point> q = new LinkedList<>();
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			arr[temp[0]][temp[1]] = 0;
			for (int[] d : delta) {
				int nr = temp[0] + d[0];
				int nc = temp[1] + d[1];
				if (arr[nr][nc] == 0)
					continue;
				arr[nr][nc] = 0;
				q.offer(new int[] { nr, nc });

			}
		}

	}

//	private static void dfs(int r, int c) {
//		arr[r][c] = 0;
//		for (int[] d : delta) {
//			int nr = r + d[0];
//			int nc = c + d[1];
//			if (arr[nr][nc] == 0)
//				continue;
//			dfs(nr, nc);
//		}
//	}
}
