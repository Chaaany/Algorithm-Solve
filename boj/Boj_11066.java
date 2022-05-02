package boj;
import java.io.*;
import java.util.*;

public class Boj_11066 {
	public static void main(String[] args) throws Exception {
		// 1. 연산은 숫자 갯수 - 1
		// 2. 매번 최소로 더할 수 있는 수를 더하면 되지 않을까? -> pq써야겠다 -> 인접하다는 걸 보장 하지 않는다.
		// 3. 최대 10000을 500 번 연산 500억 -> long
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				pq.add(Integer.parseInt(stz.nextToken()));
			}
			long answer = 0;
			while(pq.size() != 1) {
				int a = pq.poll();
				int b = pq.poll();
				int temp = a+b;
				answer += temp;
				pq.add(temp);
			}
			
			System.out.println(answer);
		}
	}
}
