package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(stz.nextToken());
		int H = Integer.parseInt(stz.nextToken());
		int X = Integer.parseInt(stz.nextToken());
		int Y = Integer.parseInt(stz.nextToken());
		int P = Integer.parseInt(stz.nextToken());
		
		// x <= px <= x + w
		// y <= py <= y + h
		// (x - px)^2 + (y+h/2 - py)^2 <= (h/2)^2
		// (x + width - px)^2 + (y+h/2 - py)^2 <= (h/2)^2
		int answer = 0;
		
		for (int i = 0; i < P; i++) {
			stz = new StringTokenizer(br.readLine());
			int px = Integer.parseInt(stz.nextToken());
			int py = Integer.parseInt(stz.nextToken());
			double leftR = Math.pow(X-px, 2)+Math.pow(Y+1.0*H/2-py, 2);
			double rightR = Math.pow(X+W-px, 2)+Math.pow(Y+1.0*H/2-py, 2);
			double rr = Math.pow(1.0*H/2, 2);
			if(X <= px && px <= X+W && Y <= py && py <= Y + H || leftR <= rr || rightR <= rr) answer++;
		}
		System.out.println(answer);
		
	}
}
