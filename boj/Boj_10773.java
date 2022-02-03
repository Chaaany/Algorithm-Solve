package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int a = 0;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			a = Integer.parseInt(br.readLine());
			if(a==0) {
				st.pop();
			}else {
				st.add(a);
			}
		}
		while(!st.isEmpty()) {
			sum+= st.pop();
		}
		System.out.println(sum);
	}
}
