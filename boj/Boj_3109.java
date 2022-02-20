package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3109 {

	static int delta[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static int R, C, cnt;
	static char arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stz.nextToken());
		C = Integer.parseInt(stz.nextToken());

		arr = new char[R][];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) dfs(i, 0);

		System.out.println(cnt);
	}

	private static boolean dfs(int r, int c) {

		if (c == C - 1) { // 도달했을 경우
			cnt++;
			return true;
		}

		for (int[] d : delta) {
			int nr = r + d[0];
			int nc = c + d[1];
			
			if (!check(nr, nc))continue;
			
			arr[nr][nc] = 'x';
			
			if (dfs(nr, nc))return true;

		}
		return false;
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < R && 0 <= nc && nc < C && arr[nr][nc] == '.';
	}
}
