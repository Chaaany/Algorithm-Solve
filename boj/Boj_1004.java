package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// x1, y1 -> 출발점 / x2, y2 -> 도착점
		
		// 각 원의 내부에 점들이 위치해 있는 지 파악하면 끝
		// (x - x1)^2 + (y - y1)^2 < r^2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			stz = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stz.nextToken());
			int y1 = Integer.parseInt(stz.nextToken());
			int x2 = Integer.parseInt(stz.nextToken());
			int y2 = Integer.parseInt(stz.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			
			for (int j = 0; j < n; j++) {
				stz = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stz.nextToken());
				int y = Integer.parseInt(stz.nextToken());
				int r = Integer.parseInt(stz.nextToken());
				
				if(Math.pow((x-x1), 2) + Math.pow((y-y1), 2) < Math.pow(r, 2)&& Math.pow((x-x2), 2) + Math.pow((y-y2), 2) > Math.pow(r, 2)) {
					answer++;
				}
				if(Math.pow((x-x1), 2) + Math.pow((y-y1), 2) > Math.pow(r, 2)&& Math.pow((x-x2), 2) + Math.pow((y-y2), 2) < Math.pow(r, 2)) {
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}
}
