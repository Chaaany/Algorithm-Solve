package boj;

import java.util.Scanner;

public class Boj_2914 {
	public static void main(String[] args) {
		// (창영이 앨범에 수록된 곡에 포함되어 있는 저작권이 있는 멜로디의 개수) / (앨범에 수록된 곡의 개수)
		
//		X / A = I -> A*(I-1) < X <= A*I
		Scanner sc = new Scanner(System.in);
	
		System.out.println(sc.nextInt() * (sc.nextInt()-1)+1);
	}
}
