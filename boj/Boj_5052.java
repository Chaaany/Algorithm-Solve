package boj;
import java.util.*;
import java.io.*;

public class Boj_5052 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			for (int j = 0; j < n; j++) {
				arr[j] = br.readLine();
			}
			if(solution(arr))sb.append("YES\n");
			else sb.append("NO\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
		
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
		a: for (int i = 0; i < phone_book.length - 1; ++i) {
			for (int j = 0; j < phone_book[i].length(); ++j) {
				if (phone_book[i].charAt(j) != phone_book[i + 1].charAt(j)) {
					continue a;
				}
			}
			answer = false;
		}

		return answer;
	}
}
