package boj;

import java.util.Scanner;

public class Boj_17945 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int tempA = (int) ((-2*A + Math.pow((4*A*A - 4 * B), 0.5))/2);
		int tempB = (int) ((-2*A - Math.pow((4*A*A - 4 * B), 0.5))/2);
		
		if(tempA < tempB) {
			System.out.println(tempA +" " + tempB);
		}else if(tempA == tempB) {
			System.out.println(tempA);
		}else {
			System.out.println(tempB + " " + tempA);
		}
	}
}
