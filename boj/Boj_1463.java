package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1463 {
	static int arr[], delta[][] = {{ 3, 0},{2,0},{1,1}}, target;
	public static void main(String[] args) {
		arr = new int[1000001];
		Arrays.fill(arr, -1);
		target = new Scanner(System.in).nextInt();
		bfs();
		System.out.println(arr[target]);
		
	}
	private static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		arr[1] = 0;
		int temp = 0;
		int n = 0;
		while(!q.isEmpty()) {
			temp = q.poll();
			for (int i = 0; i < 3; i++) {
				n = temp*delta[i][0] + delta[i][1];
				if(!(0< n && n <= 1000000 && arr[n]== -1))continue;
				q.add(n);
				arr[n] = arr[temp] + 1;
				if(n == target) return;
			}
		}
	}
}
