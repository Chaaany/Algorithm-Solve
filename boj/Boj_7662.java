package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_7662 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
		PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		int size=0, T, N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		String key;
		int value, max, min;
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				stz = new StringTokenizer(br.readLine());
				key = stz.nextToken();
				
				value = Integer.parseInt(stz.nextToken());
				if(key.equals("I")) {
					size++;
					pqAsc.add(value);
					pqDesc.add(value);
				} else {
					if(size == 0) continue;
					if(value == -1) { // 최솟값 삭제
						pqAsc.poll();
						size--;
						if(size == 0) {
							while(!pqDesc.isEmpty())pqDesc.poll();
						}
					}else { // 최댓값 삭제
						pqDesc.poll();
						size--;
						if(size == 0) {
							while(!pqAsc.isEmpty())pqAsc.poll();
						}
					}
				}
			}
			if(size == 1) {
				if(pqAsc.size() == 1) {
					max = pqAsc.poll();
					min = max;
				}else if(pqDesc.size() ==1) {
					max = pqAsc.poll();
					min = max;
				}
			} else if (size == 0) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(pqDesc.poll() +" "+ pqAsc.poll()).append("\n");
			}
			pqAsc.clear();
			pqDesc.clear();
		}
		System.out.println(sb);
		
	}
}
