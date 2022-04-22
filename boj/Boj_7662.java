package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
		for (int i = 0; i < T; i++) {
			int value, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			TreeMap<Integer, Integer> tm = new TreeMap<>();
//			System.out.println("----------------------------");
			N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				stz = new StringTokenizer(br.readLine());
				key = stz.nextToken();
				
				value = Integer.parseInt(stz.nextToken());
				
				if(key.equals("I")) { // 숫자 넣기
					size++;
					int temp = tm.get(value) == null || tm.get(value) == 0 ? 1 : tm.get(value);
					tm.put(value, temp);
//					System.out.println("size : " +size + ", " +key +" : " + value + "=" + value);
					pqAsc.add(value);
					pqDesc.add(value);
				} else {
					if(size == 0) continue;
					
					if(value == -1) { // 최솟값 삭제
						size--;
						int temp = pqAsc.poll();
						tm.put(temp, tm.get(temp)-1);
//						System.out.println("size : " +size + ", " +key +" : " + value + "=" + pqAsc.poll());
						if(size == 0) {
							pqAsc.clear();
							pqDesc.clear();
						}
					}else { // 최댓값 삭제
						size--;
						int temp = pqDesc.poll();
						tm.put(temp, tm.get(temp)-1);
//						System.out.println("size : " +size + ", " +key +" : " + value + "=" + pqDesc.poll());
						if(size == 0) {
							while(!pqAsc.isEmpty())pqAsc.poll();
						}
					}
				}
			}
			
			if(size >= 1) {
				while(!pqDesc.isEmpty()) {
					int temp = pqDesc.poll();
					if(tm.get(temp)!= 0) {
						max = temp;
						break;
					}
				}
				
				while(!pqAsc.isEmpty()) {
					int temp = pqAsc.poll();
					if(tm.get(temp)!= 0) {
						min = temp;
						break;
					}
				}
				min = min == Integer.MAX_VALUE ? max : min;
				max = max == Integer.MIN_VALUE ? min : max;
				
				sb.append(max +" "+ min).append("\n");
			} else {
				sb.append("EMPTY").append("\n");
			}
			pqAsc.clear();
			pqDesc.clear();
			size = 0;
		}
		System.out.println(sb);
		
	}
}