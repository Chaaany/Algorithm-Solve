package boj;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Boj_15666 {
	static int n, m, arr[], nums[];
	static StringBuilder sb;
	static LinkedHashSet<String> lhs = new LinkedHashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		nums = new int[m];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		start(0, 0);
		sb = new StringBuilder();
		for (String answer : lhs) {
			sb.append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
	
	}
	private static void start(int start, int cnt) {
		if(cnt == m) {
			sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			lhs.add(sb.toString());
			return;
		}
		for (int i = start; i < n; i++) {
			nums[cnt] = arr[i];
			start(i, cnt+1);
		}
	}
}
