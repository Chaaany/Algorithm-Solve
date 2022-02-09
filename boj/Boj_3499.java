package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_3499 {
	static String[] deque, first, second;
	static int T, N;
	static StringBuilder sb;
	static BufferedReader br;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			first = new String[N]; // 패딩
			second = new String[N]; // 패딩
			deque = br.readLine().trim().split(" ");
//			System.out.println(Arrays.toString(deque)); // 입력 테스트
			if (deque.length % 2 == 0) { // 덱이 짝수면
				for (int i = 0; i < deque.length / 2; i++) { // 앞쪽 반
					first[i] = deque[i];
				}
				for (int i = 0; i < deque.length / 2 ; i++) { // 뒤쪽 반
					second[i] = deque[i+(deque.length/2)];
				}
				int index = 0;
				while(index < deque.length) {
					deque[index] = first[index/2];
					index++;
					deque[index] = second[index/2];
					index++;
				}
				
			} else { // 홀수면
				for (int i = 0; i < (deque.length / 2)+1; i++) { // 앞쪽 반
					first[i] = deque[i];
				}
				for (int i = 0; i < deque.length / 2 ; i++) { // 뒤쪽 반
					second[i] = deque[i+(deque.length/2)+1];
				}
				int index = 0;
				while(index < deque.length-1) {
					deque[index] = first[index/2];
					index++;
					deque[index] = second[index/2];
					index++;
				}
				//마지막 한장 처리
				deque[index] = first[index/2]; 
			}
			sb.append("#"+ t);
			for (String card : deque) {
				sb.append(" "+card);
			}
			sb.append("\n");
 		}
		System.out.println(sb);
	}
}