package jg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jg_냉장고_1828 {
	static int degrees[][], left= 10001, right= -271, answerDegrees[][], cnt;	
	static boolean[] available; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		degrees = new int[N][2];
		available = new boolean[N];
		answerDegrees = new int[100][2];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			degrees[i][0] = Integer.parseInt(stz.nextToken()); 
			degrees[i][1] = Integer.parseInt(stz.nextToken());
			
		}
		
		Arrays.sort(degrees, (a , b) ->{
			return Integer.compare(a[1], b[1]);
		});
		cnt = 1;
		right = degrees[0][1];
		for (int i = 1; i < N; i++) {
			if(right < degrees[i][0]) {
				right = degrees[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
