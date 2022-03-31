package boj;

import java.util.Scanner;

public class Boj_11053 {
	static int arr[], n, answer;

	public static void main(String[] args) {
		// 1 <= 수열 A의 크기 <= 1,000, 1 <= A <= 1,000 -> int 선언 가능
		// n번째까지의 부분 수열 {이전까지의 최대 수,수열 길이} = {n번째 수 > n-1번째까지의 최대 수 ? n : n-1번째까지의 최대수,
		// n번째 수 > n-1번째까지의 최대 수 ? 이전까지 수열길이+1 : 이전까지의 수열 길이}
		// 입력 받을 수 최대 1001개 이므로 scanner나 bufferedreader&stringtokenizer 둘중 하나 쓰면 됨
		Scanner sc = new Scanner(System.in);
		// 2차원 배열에 정렬을 A의 크기 기준으로 오름차순 정렬한 후 인덱스 넘버 기준으로 dp배열 만들기

		int n = sc.nextInt();
		int arr[] = new int[n + 1];// 패딩사용(점화식 이 A(n) = A(n-1) 개념이므로. n=1일떄 n=0 필요
		int dp[] = new int[n + 1]; // 패딩사용(점화식 이 A(n) = A(n-1) 개념이므로. n=1일떄 n=0 필요
		int answer = 1;
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;// 모두 자기자신만으로 수열 구성할 경우 1에 해당함.
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i-1; j > 0 ; j--) {
				//i 보다 작은 곳 돌면서 i보다 arr[j]값이 arr[i]보다 작고 dp[j]값이 dp[i]값 보다 크거나 같으면 max과 비교하여 갱신
				if(arr[j] < arr[i] && dp[j] >= dp[i]) { 
					dp[i] = Math.max(dp[i], dp[j])+1;
				}
			}
//			System.out.println(i + "번째의 최장 길이" + dp[i]);
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);

	}

	// 조건이 가장 '긴' '증가하는' '수열'
	// 1. 부분집합 = 2^n승 => 불가
	// 2. 뒤에서부터 보면 가장 긴 감소하는 '수열'찾기 문제로 변모
	// 3. n번째 수까지에서 최장 길이 수열은 = n-1번째 수까지의 최장 길이 수열 or (n-1번째 수까지의 최장 길이 수열 + 1)
	// 4. 최장 길이 수열은 어떻게 구할까? -> n번쨰 까지의 최장 길이 수열 = n번째 수 > n-1 일 경우 n번째 수를 넣은 수열 or
	// n번째 수를 넣지 않으
	// 10 20 10 30 20 50
	// O O X O X O
	// 8 6 9 1 4 6 7 4 3 7 4 7 2 5 2 10 1
	// 1 1 2 1 2 3 4 2 2 4 3 4 2 4 2 5 1
	// 8
	// O
	// 8 6
	// O X
	// X O
	// 8 6 9
	// X O O
	// 8 6 9 1
	// X O O X
	// 8 6 9 1 4
	// X O O X X
	// 8 6 9 1 4
	// O X O X X
	// 8 6 9 1 4
	// X X X O O
	// 8 6 9 1 4
	// O X O X X
	// 8 6 9 1 4 6
	// X X X O O O

}
