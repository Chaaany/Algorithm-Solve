package boj;
import java.util.Arrays;
import java.util.Scanner;

public class boj_10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] testcase = new int[3];
		for (int i = 0; i < testcase.length; i++) {
			testcase[i] = sc.nextInt();
		}
		Arrays.sort(testcase);
		System.out.println(testcase[testcase.length-2]);
	}
}
