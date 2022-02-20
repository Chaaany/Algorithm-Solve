package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1992 {
	static int N, arr[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			char temp[] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = temp[j] - '0';
			}
		}

		quadtree(0, 0, N);

		System.out.print(sb);

	}

	private static void quadtree(int r, int c, int size) {

		// 압축 가능 -> 압축이 가능하다는 건 한 숫자로 이루어져 있다는 뜻
		if (check(r, c, size)) {
			sb.append(arr[r][c]);
			return;
		}
		
		int tempsize = size / 2;

		sb.append("(");
		// 압축 불가능
		quadtree(r, c, tempsize);
		quadtree(r, c + tempsize, tempsize);
		quadtree(r + tempsize, c, tempsize);
		quadtree(r + tempsize, c + tempsize, tempsize);

		sb.append(")");
	}

	private static boolean check(int r, int c, int size) {

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != arr[r][c])
					return false;
			}
		}
		return true;
	}
}
