package boj;
import java.util.Scanner;

public class boj_10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] answer = new int[sc.nextInt()];
		for(int i = 0; i < answer.length; i++ ) {
			String[] inputdata = sc.next().split(",");
			answer[i] = Integer.parseInt(inputdata[0]) + Integer.parseInt(inputdata[1]);
		}
		for (int i : answer) {
			System.out.println(i);
		}
	}
}
