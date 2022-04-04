package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 연속된 수의 합
		// 10	-4	3	1	5	6	-35	12	21	-1
		// 10	6	9	10	15	21	X	12	33	33
		// 10	10	10	10	15	21		21	33	33
		
		// 2	1	-4	3	4	-4	6	5	-5	1
		// 2	3	X	3	7	3	9	14	9	10
		// 2	3	3	3	7	7	9	14	14	14
		
		// -1	-2	-3	-4	-5
		// -1	-1	-1	-1	-1
		
		// 1. 1번 부터 i번까지 더했다 => dp에 max값 갱신하면서 이제 더한 수가 0일 때는 커서를 그다음의 양수값으로 옮김 그때까지는 dp배열에 최댓값을 넣는다.
		// 2. 1 <= n <= 100,000 / -1,000 <= ni < 1,000 // total 최대 100,000,000 / 최소 -100,000,000 -> int 배열 선언
		// 3. 100,000 -> BR, STZ
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][2];
		stz = new StringTokenizer(br.readLine());
		int max = -1001;
		int Lcursor = -1;
		int Rcursor = -1;
		for (int i = 1; i <= n; i++) {
			arr[i][0] = Integer.parseInt(stz.nextToken());
			if(arr[i][0] + arr[i-1][1] > 0) {
				arr[i][1] = arr[i][0] + arr[i-1][1];
				max = Math.max(max, arr[i][1]);
				if(Lcursor == -1 && Rcursor == -1) { // 이전 값에서 누적합 하지 않은 경우
					Lcursor = i; // 커서 시작
					Rcursor = i;		
				}
				Rcursor = i;
			}else { // 누적합 안하는 경우 -> 초기화
				arr[i][1] = 0;
				Lcursor = -1;
				Rcursor = -1;
				max = Math.max(max, arr[i][0]);
			}
		}
		System.out.println(max);
		
	}
}
