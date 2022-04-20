package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_1021 {
	public static void main(String[] args) throws IOException {
		// 1번 연산 : poll
		// 2번 연산 : pushright(popleft)
		// 3번 연산 : pushleft(popright)
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(stz.nextToken());
		int N = Integer.parseInt(stz.nextToken());
		int answer = 0;
		Deque<Integer> dq1 = new ArrayDeque<>();
		Deque<Integer> dq2 = new ArrayDeque<>();
		
		for (int i = 1; i <= M; i++) {
			dq1.addLast(i);
			dq2.addLast(i);
		}
		
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(stz.nextToken()); 
			answer += Math.min(CCW(dq1, target), CW(dq2, target));
		}
		System.out.println(answer);
		
	}

	private static int CW(Deque<Integer> dq, int target) {
		int cnt = 1;
		while(true) {
			int temp = dq.pollLast();
			if(temp == target) {
				return cnt;
			}else {
				cnt++;
				dq.addFirst(temp);
			}
			
		}
	}

	private static int CCW(Deque<Integer> dq, int target) {
		int cnt = 0;
		while(true) {
			int temp = dq.pollFirst();
			if(temp == target) {
				return cnt;
			}else {
				cnt++;
				dq.addLast(temp);
			}
			
		}
	}
}
