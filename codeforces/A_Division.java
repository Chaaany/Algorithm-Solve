package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Division {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int rating = Integer.parseInt(br.readLine());
			if(1900 <= rating) {
				sb.append("Division 1\n");
			}else if(1600 <= rating && rating <=1899) {
				sb.append("Division 2\n");
			}else if(1400 <= rating && rating <= 1599) {
				sb.append("Division 3\n");
			}else {
				sb.append("Division 4\n");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
}
