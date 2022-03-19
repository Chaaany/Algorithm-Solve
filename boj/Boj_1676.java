package boj;

import java.util.Scanner;

public class Boj_1676 {
	public static void main(String[] args) {
		int cnt = 0;
		int temp = 0;
		int index = new Scanner(System.in).nextInt();
		for (int i = 5; i <= index ; i+=5) {
			temp = i;
			while(temp % 5 == 0 && temp != 0) {
				cnt++;
				temp /= 5;
			}
		}
		System.out.println(cnt);
	}
}
