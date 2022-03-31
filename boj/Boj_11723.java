package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11723 {
	static boolean arr[] = new boolean[21];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer stz = new StringTokenizer(br.readLine());
			String key = stz.nextToken();
			int value;
			switch (key) {
			case "add":
				value = Integer.parseInt(stz.nextToken());
				add(value);
				break;
			case "remove":
				value = Integer.parseInt(stz.nextToken());
				remove(value);
				break;
			case "check":
				value = Integer.parseInt(stz.nextToken());
				check(value);
				break;
			case "toggle":
				value = Integer.parseInt(stz.nextToken());
				toggle(value);
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		
		System.out.println(sb.toString());

	}

	private static void add(int value) {
		arr[value] = arr[value] ? true : true;
	}

	private static void remove(int value) {
		arr[value] = arr[value] ? false : false;
	}

	private static void toggle(int value) {
		arr[value] = arr[value] ? false : true;
	}

	private static void check(int value) {
		int answer = 0;
		answer = arr[value] ? 1 : 0;
		sb.append(answer).append("\n");
	}

	private static void all() {
		for (int i = 1; i <= 20; i++) {
			arr[i] = true;
		}
	}

	private static void empty() {
		for (int i = 1; i <= 20; i++) {
			arr[i] = false;
		}
	}
}
