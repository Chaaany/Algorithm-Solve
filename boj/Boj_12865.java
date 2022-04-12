package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12865 {
	public static void main(String[] args) throws IOException {
		// 1 <= 물품의 수 N <= 100 / 1 <= 준서가 버틸 수 있는 무게 K <= 100,000
		// 1 <= 물건 무게 W < 100,000 / 0 <= 물건의 가치 <= 1,000
		// 물건의 무게가 겹칠 수도 있음
		// 최대 100,000 -> int배열 가능
		// 점화식
		// 1. K보다 W가 작거나 같다.
		// 점화식
		// dp(n, w) = max(n번째 아이템을 포함하면서 최대인 경우 or n번째 아이템을 포함하지 않으면서 최대인 경우)
		// 		 = max(n번쨰의 k + dp(n-1,w-n번째w) or dp(n-1, w) (w > n번째 w)  

		
		int N, K, arr[][], dp[][];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());
		arr = new int[N+1][2];
		dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = Integer.parseInt(stz.nextToken());
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j < arr[i][0]) { // 배낭 보다 무게가 큰 물품인 경우
					dp[i][j] = dp[i-1][j];
				}else {  // 고려할 배낭보다 무게가 작은 물품인 경우 
					dp[i][j] = Math.max(arr[i][1] + dp[i-1][j-arr[i][0]], dp[i-1][j] );
//					System.out.println("여기"+i +" "+dp[i][j]);
				}
			}
//			System.out.println(i+"번째"+dp[i][K] + " " + arr[i][1]);
		}
		
		System.out.println(dp[N][K]);
	}
}
