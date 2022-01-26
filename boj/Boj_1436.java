package boj;

import java.util.Scanner;

public class Boj_1436 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int index = 0;
//		int answer = sc.nextInt();
//		int i = 0;
//		while(answer != index) {
//			if(Integer.toString(i++).contains("666")) {
//				index++;
//			}
//		}
//		System.out.println(--i);
		int n = new java.util.Scanner(System.in).nextInt(), a=2 ;
		while (n > 0)
			if (new String(++a + "").indexOf("666") >= 0)
				n--;
		System.out.print(a);
	}
}
