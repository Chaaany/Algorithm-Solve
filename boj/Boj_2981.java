package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2981 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 근처에 보이는 숫자 N개를 종이에 적는다. 그 다음, 종이에 적은 수를 M으로 나누었을 때, 나머지가 모두 같게 되는 M을 모두 찾으려고 한다. M은 1보다 커야 한다.
		// 2. 2 <= 적은 숫자의 갯수 N <= 100, 1 <= 종이에 적힌 각각의 수 <=1,000,000,000 -> int형 선언
		// 3. 같은 수가 두 번 이상 주어지지 않음 => 딱 한 번 주어짐
		// 제한시간 1초 -> 10억번 연산 불가 (시간 초과)
		// 6 34 38
		// 28 4
		// 2, 4
		// 5 14 17 23 83
		// 3
		// 9 3 6 60
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int gcdVal = arr[1] - arr[0];
		
		for (int i = 1; i < N-1; i++) {
			gcdVal = gcd(gcdVal, arr[i+1] - arr[i]);
		}
		
		int i;
		for (i = 2; i*i <= gcdVal; i++) {
			if(gcdVal % i == 0)sb.append(i).append(" "); 
		}
		
		while(i-->1) {
			if(i*i == gcdVal) continue;
			if(gcdVal % i == 0) sb.append(gcdVal / i).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static int gcd(int a, int b) {
		while(b!= 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
