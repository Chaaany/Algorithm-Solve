package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3036 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}		
		
		for (int i = 1; i < N; i++) {
			int gcdVal = gcd(arr[0], arr[i]);
			sb.append(arr[0] / gcdVal).append("/").append(arr[i] / gcdVal).append("\n");
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
