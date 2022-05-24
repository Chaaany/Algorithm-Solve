package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3273 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1 2 3 4 
		// 1 2 3 5 7 10 11 12
		// O O          O  O
		// 1. 각 끝에서 시작
		// 2. 합보다 클경우 오른쪽 포인터를 --, 합보다 작은 경우 왼쪽 포인터를 ++
		// 3. 합과 같을 경우 왼쪽 ++, 오른쪽 ++
		// 4. 왼쪽 포인터 < 오른쪽포인터 일때까지 반복
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		
		int target = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = n-1;
		int cnt = 0;
		while(left < right) {
			int sumV = arr[left] + arr[right];
			if(sumV < target) {
				left++;
			}else if(sumV == target) {
				cnt++;
				left++;
				right--;
			}else {
				right--;
			}
		}
		System.out.println(cnt);
	}
}
