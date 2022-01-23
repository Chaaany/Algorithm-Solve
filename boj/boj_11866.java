package boj;
import java.util.Scanner;

public class boj_11866 {
	private static int N;
	private static int K;
	private static int index;
	private static int[] nums;
	private static int[] answer;	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		nums = new int[N];
		answer = new int[N];

		for (int i = 0; i < nums.length; i++) { // 1~N으로 배열 초기화
			nums[i] = i+1;
		}

		for(int i = 0; i < N; i++) { // 숫자 N개 전부 확인

			for (int j = 0; j < K; j++) { // K번 이동
				index = move(index);
			}
			if (index == 0) { // 인덱스 = index % N 따라서 N으로 변환
				answer[i] = N;
			} else {
				answer[i] = index;
			}
			nums[index] = 0; // 이미 확인하였다고 표시
		}
//		출력
		System.out.print("<");
		for (int i = 0; i < N; i++) {
			if (i == N-1) {
				System.out.print(answer[i]+">");
			} else {
				System.out.print(answer[i] + ", ");
			}
		}

	}

	public static int move(int index) {
		int tmpIndex = (index+1) % N;
		if(nums[tmpIndex] != 0) { //1 이동 시 기확인 여부
			return tmpIndex;
		} else { // 확인하지 않은 곳 탐색
			return move(tmpIndex);
		}		
	}
}