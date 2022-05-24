package boj;

import java.util.Scanner;
import java.util.TreeSet;

public class Boj_11478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().trim();
		TreeSet<String> ts = new TreeSet<>();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				if(ts.contains(str.substring(i, j+1)))continue;
				ts.add(str.substring(i, j+1));
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
