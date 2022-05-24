package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_13549 {
	static int arr[];
	static int N, K;

	public static void main(String[] args) {
		// 0 <= 수빈 <= 100,000, 0 <= 동생 <= 100,000
		// 걷기 = X-1, X+1 -> 1초 / 순간이동 2*X-> 0초
		// 동생보다 수빈이가 너 낮은 수의 점에 있을 땐 순간이동을 사용

		Scanner sc = new Scanner(System.in);
		arr = new int[100001]; // 0부터 100,000까지
		N = sc.nextInt();
		K = sc.nextInt();
		Arrays.fill(arr, -1);
		if (N >= K) {
			System.out.println(N - K);
		} else {
			bfs();
			System.out.println(arr[K]); 
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		arr[N] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == K) {
				return;
			}
			
			int teleport = cur*2;
			int walkBackward = cur-1;
			int walkForward = cur+1;
			
			
			if(teleport <= 100000 && arr[teleport] < arr[cur] ) {
				arr[teleport] = arr[cur];
//				System.out.println("tp : " + teleport + ", "+arr[teleport]);
				q.add(teleport);
			}
			
			if(0 <= walkBackward && arr[walkBackward] == -1) {
				arr[walkBackward] = arr[cur] + 1;
//				System.out.println("BW : " + walkBackward + ", "+arr[walkBackward]);
				q.add(walkBackward);
			}
			if(walkForward <= 100000 &&arr[walkForward] == -1) {
				arr[walkForward] = arr[cur] + 1;
//				System.out.println("FW : " + walkForward + ", "+arr[walkForward]);
				q.add(walkForward);
			}
		}
	}
}
