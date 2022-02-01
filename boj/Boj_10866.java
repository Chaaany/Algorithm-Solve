package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10866 {
	private static int size = 0;
	private static int[] deque;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		deque = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
			String command = stz.nextToken();
			switch (command) {
			case "push_front":
				pushFront(command, stz.nextToken());
				break;
			case "push_back":
				pushBack(command, stz.nextToken());
				break;
			case "pop_front":
				sb.append(popFront()).append("\n");
				break;
			case "pop_back":
				sb.append(popBack()).append("\n");
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
		return size == 0 ? -1 : deque[size - 1];
	}

	private static int front() {
		return size == 0 ? -1 : deque[0];
	}

	private static int empty() {
		return size == 0 ? 1 : 0;
	}

	private static int size() {
		return size;
	}

	private static int popBack() {
		return size == 0 ? -1 : deque[size-- - 1];
	}

	private static int popFront() {
		if (size == 0) {
			return -1;
		} else {
			int tmp = deque[0];
			for (int i = 1; i < size; i++) {
				deque[i - 1] = deque[i];
			}
			size--;
			return tmp;
		}
	}

	private static void pushBack(String command, String nextToken) {
		deque[size++] = Integer.parseInt(nextToken);
	}

	private static void pushFront(String command, String nextToken) {
		if (size != 0) {
			int[] temp = Arrays.copyOf(deque, size);
			deque[0] = Integer.parseInt(nextToken);
			size++;
			for (int i = 1; i < size; i++) {
				deque[i] =temp[i-1];
			}
		} else {
			size++;
			deque[0] = Integer.parseInt(nextToken);
		}

	}
}
