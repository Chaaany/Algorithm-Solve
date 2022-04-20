package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Boj_18258 {
	static class Q {
		int lastIdx;
		int firstIdx;
		List<Integer> q;
		
		
		public Q() {
			this.lastIdx = 0;
			this.lastIdx = 0;
			this.q = new ArrayList<>();
			
		}

		void push(int X) {
			q.add(X);
			lastIdx++;
		}
		
		int pop() {
			return firstIdx == lastIdx ? -1 : q.get(firstIdx++);
		}
		
		int size() {
			return lastIdx - firstIdx;
		}
		
		int empty() {
			return firstIdx == lastIdx ? 1 : 0;
		}
		
		int front() {
			return firstIdx == lastIdx ? -1 : q.get(firstIdx);
		}

		int back() {
			return firstIdx == lastIdx ? -1 : q.get(lastIdx-1);
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;
		Q q = new Q();
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			String key = stz.nextToken();
			
			switch (key) {
			case "push":
				int X = Integer.parseInt(stz.nextToken());
				q.push(X);
				break;
			case "pop":
				sb.append(q.pop()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				sb.append(q.empty()).append("\n");
				break;
			case "front":
				sb.append(q.front()).append("\n");
				break;
			case "back":
				sb.append(q.back()).append("\n");
				break;
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}
}
