package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj_1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stz.nextToken());
		int B = Integer.parseInt(stz.nextToken());
		// A = a + c
		// B = c + B
		// A - B = a - b
		// B - A = B - A
		
		TreeSet<Integer> tsA = new TreeSet<>();
		TreeSet<Integer> tsB = new TreeSet<>();
		int duple = 0;
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			tsA.add(Integer.parseInt(stz.nextToken()));
		}
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			int temp = Integer.parseInt(stz.nextToken());
			tsB.add(temp);
			if(tsA.contains(temp))duple++;
		}
		
		System.out.println(A + B - 2 * duple);
		
		
		
	}
}
