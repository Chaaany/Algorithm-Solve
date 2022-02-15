package swea;

import java.util.Scanner;

public class Solution_D3_1280_원재의메모리복구하기 {
	
	public static void main(String[] args) {
		int T = 0, cnt = 0;
		char pointer = '0';
		Scanner sc = new Scanner(System.in);
		String s = "";
		T = sc.nextInt();
		
		
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			pointer = '0';
			s = sc.next();
			
			for (int i = 0; i < s.length(); i++) {
				
				if(s.charAt(i) != pointer) {
					pointer = s.charAt(i);
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
		
	}
	
}
