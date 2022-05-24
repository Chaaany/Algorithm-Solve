package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Boj_10815 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//		TreeMap<Integer, Boolean> tm = new TreeMap<>();
		TreeSet<Integer> ts = new TreeSet<>();
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ts.add(Integer.parseInt(stz.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(stz.nextToken());
			if(ts.contains(key)) {
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
		
	}
}
