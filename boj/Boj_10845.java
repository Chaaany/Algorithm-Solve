package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10845 {
	private static int queue[];
	private static int size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String index;
		queue = new int[N];

		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			index = stz.nextToken();
			switch (index) {
			case "push":
				push(index, stz.nextToken());
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
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}

	private static int back() {
		return size == 0 ? -1 : queue[size - 1];
	}

	private static int front() {
		return size == 0 ? -1 : queue[0];
	}

	private static int empty() {
		return size == 0 ? 1 : 0;
	}

	private static int size() {
		return size;
	}

	private static void push(String index, String nextToken) {
		queue[size++] = Integer.parseInt(nextToken);
	}

	private static int pop() {
		if (size != 0) {
			int tmp = queue[0];
			for (int i = 1; i < size; i++) {
				queue[i - 1] = queue[i];
			}
			size--;
			return tmp;
		} else {
			return -1;
		}

	}

}
