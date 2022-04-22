package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F_Eating_Candies {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		int answer = -1;
		int arr[]; 
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(stz.nextToken());
			}
			int left = -1;
			int right = N;
			int cnt = 0;
			int leftTotal = 0;
			int rightTotal = 0;
			while(left < right) {
				if(leftTotal == rightTotal) {
					System.out.println("같을 때-" +left + ":" + leftTotal + " / "+ right + ":" + rightTotal );
					answer = Math.max(answer, cnt);
					left++;
					right--;
					rightTotal += arr[right];
					leftTotal += arr[left];
					cnt++;
					cnt++;
				}else if(leftTotal > rightTotal) {
					System.out.println("왼쪽이 더 클때 - "+left + ":" + leftTotal + " / "+ right + ":" + rightTotal );
					rightTotal += arr[right];
					right--;
					cnt++;
				}else {
					System.out.println("오른쪽이 더 클 때- "left + ":" + leftTotal + " / "+ right + ":" + rightTotal );
					leftTotal += arr[left];
					cnt++;
					left++;
				}
			}
			sb.append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}
}
