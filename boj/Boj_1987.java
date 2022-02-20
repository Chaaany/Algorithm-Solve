package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987 {
	static int R, C, cnt, max = -1;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());

		R = Integer.parseInt(stz.nextToken());
		C = Integer.parseInt(stz.nextToken());
		arr = new char[R][];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		check(0, 0, 0,new boolean['Z' - 'A' + 1]);
		
		System.out.println(max);

	}

	private static void check(int r, int c, int cnt, boolean v[]) {
		if (!isOutOfBoundary(r, c))
			return ;
		
		if (v[arr[r][c] - 'A']) {
			max = Math.max(max, cnt);
			return ;// 프루닝 -> 기방문
		}else {
			v[arr[r][c] - 'A'] = true;
			check(r - 1, c, cnt+1, v);
			check(r, c + 1, cnt+1, v); 
			check(r + 1, c, cnt+1, v);
			check(r, c - 1, cnt+1, v); 
			
			v[arr[r][c] - 'A'] = false;
		}
	}

	private static boolean isOutOfBoundary(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}