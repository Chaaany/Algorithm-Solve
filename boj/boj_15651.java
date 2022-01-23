package boj;
import java.util.Scanner;

public class boj_15651 {
	private static int cur;
	private static int M;
	private static int N;
	private static int[] arr;
	
	
	public static void recur(int cur) {
		if (cur == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println("");
			return ;
		}
		for (int i = 0; i < M; i++) {
			arr[cur] = i;
			recur(cur+1);
		}
		
	}
		
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M];
		
		recur(0);
		
	}
}
