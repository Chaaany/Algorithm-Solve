package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11728 {
	private static int[] n;
	private static int[] m;
	private static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		n = new int[N];
		m = new int[M];
		ans = new int[N + M + 1];
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(stz.nextToken());
		}
		Arrays.sort(n);
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < m.length; i++) {
			m[i] = Integer.parseInt(stz.nextToken());
		}
		Arrays.sort(m);
		merge();
		for (int i = 0; i < N + M; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}

	private static void merge() {

		int a = 0;
		int b = 0;
		int c = 0;
		while (a < n.length && b < m.length) {
			ans[c++] = n[a] < m[b] ? n[a++] : m[b++];
		}
		while (b < m.length) {
			ans[c++] = m[b++];
		}
		while (a < n.length) {
			ans[c++] = n[a++];
		}

	}
}
