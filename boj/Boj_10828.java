package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_10828 {
	private static int stack[];
	private static int size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			switch (str[0]) {
			case "push":
				push(str[1]);
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "top":
				sb.append(top()).append("\n");
				break;

			}
		}
		System.out.println(sb.toString());
	}

	private static int top() {
		return size == 0 ? -1 : stack[size-1];
	}

	private static int empty() {
		return size == 0 ? 1 : 0;
	}

	private static int size() {
		return size;
	}

	private static int pop() {
		if ( size != 0 ) {
			return stack[size-- -1];
		} else {
			return -1;
		}
	}

	private static void push(String str) {
		stack[size++] = Integer.parseInt(str);
	}
}
