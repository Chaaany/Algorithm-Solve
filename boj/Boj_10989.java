package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10989 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10001];
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int index = Integer.parseInt(br.readLine());
			arr[index]++;
		}
		for (int i = 0; i < 10001; i++) {
			for (int j = 0; j < arr[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}
