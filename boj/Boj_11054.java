package boj;

import java.util.Scanner;

public class Boj_11054 {
	static int arr[], n, answer;

	public static void main(String[] args) {
		// 최장 수열을 두포인터 개념으로 구하면 되지 않을까?
		// 1 <= 수열 A의 크기 <= 1,000, 1 <= A <= 1,000 -> int 선언 가능
		// n번째 수 > n-1번째까지의 최대 수 ? 이전까지 수열길이+1 : 이전까지의 수열 길이}
		// 입력 받을 수 최대 1001개 이므로 scanner나 bufferedreader&stringtokenizer 둘중 하나 쓰면 됨
		Scanner sc = new Scanner(System.in);
		// 2차원 배열에 정렬을 A의 크기 기준으로 오름차순 정렬한 후 인덱스 넘버 기준으로 dp배열 만들기

		int n = sc.nextInt();
		int arr[] = new int[n + 1];// 패딩사용(점화식 이 A(n) = A(n-1) 개념이므로. n=1일떄 n=0 필요
		int dp[][] = new int[n + 1][2]; // 패딩사용(점화식 이 A(n) = A(n-1) 개념이므로. n=1일떄 n=0 필요
		int answer = 1;
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			dp[i][0] = 1;// 모두 자기자신만으로 수열 구성할 경우 1에 해당함.
			dp[i][1] = 0;// 모두 자기자신만으로 수열 구성할 경우는 증가하는 최장 수열에 넣어놨음 해당함.
		}
		// 증가하는 최장 수열 구하기
		for (int i = 1; i <= n; i++) {
			for (int j = i-1; j > 0 ; j--) {
				//i 보다 작은 곳 돌면서 i보다 arr[j]값이 arr[i]보다 작고 dp[j]값이 dp[i]값 보다 크거나 같으면 max과 비교하여 갱신
				if(arr[j] < arr[i] && dp[j][0] >= dp[i][0]) { 
					dp[i][0] = Math.max(dp[i][0], dp[j][0])+1;
				}
			}
		}
		
		// 감소하는 최장 수열 구하기
		for (int i = n; i >= 1; i--) {
			for (int j = i+1; j <= n ; j++) {
				//i 보다 큰 곳 돌면서 i보다 arr[j]값이 arr[i]보다 크고 dp[j]값이 dp[i]값 보다 크거나 같으면 max과 비교하여 갱신
				if(arr[i] > arr[j] && dp[i][1] <= dp[j][1]) { 
					dp[i][1] = Math.max(dp[i][1], dp[j][1])+1;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
//			System.out.println(i +"번째에서 만들 수 있는 증가하는 최장 수열 :" + dp[i][0] +"&&" + i + "번째에서 만들 수 있는 감소하는 최장 수열 :" + dp[i][1]);
			answer = Math.max(answer, dp[i][0]+dp[i][1]);
		}
		System.out.println(answer);

	}
//	10
//	1 5 2 1 4 3 4 5 2 1
//	1 2 2 1 3 3 4 5 2 1
//	1 5 2 1 4 3 3 3 2 1
}
