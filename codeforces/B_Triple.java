package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B_Triple {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(stz.nextToken());
				if(tm.containsKey(temp)) {
					tm.put(temp, tm.get(temp)+1);
				}else {
					tm.put(temp, 1);
				}
			}
			for ( Integer key : tm.keySet() ) {
			    if(tm.get(key) >= 3) {
			    	answer = key;
			    	break;
			    }
			}
			answer = answer == 0 ? -1 : answer;
			sb.append(answer).append("\n");
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
