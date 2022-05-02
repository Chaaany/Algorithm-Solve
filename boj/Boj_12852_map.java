package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_12852_map {
	static List[] arr;
	static int n, answer;
	public static void main(String[] args) {
//		1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
//		2. X가 2로 나누어 떨어지면, 2로 나눈다.
//		3. 1을 뺀다.
		// 정답 횟수 및 도출 과정 누적적으로 쌓아두고 출력

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) { // 리스트 할당
			arr[i] = new ArrayList<Integer>();
		}
		int index = 0;
		StringBuilder sb = new StringBuilder();
		arr[n].add(n);//시작점 넣어두기
		answer = Integer.MAX_VALUE;
		start(n, 0);
		
		for (int i = 0; i < arr[1].size(); i++) {
			sb.append(arr[1].get(i)).append(" ");
		}
		sb.setLength(sb.length()-1);
		
		//정답출력
		if(answer == Integer.MAX_VALUE) {
			System.out.println(0 + "\n" + sb);
		}else {
			System.out.println(answer +"\n"+ sb);
		}
	}

	private static void start(int n, int index) {
		if(n <= 1 || arr[n].isEmpty() || !arr[1].isEmpty()) {
//			System.out.println("return");// n이 이미 1이하로 도달했거나, 이미 방문한 곳이라면 return;
			return;
		}
		index++;
		if (n % 3 == 0 && arr[n / 3].isEmpty()) { // 3으로 나눌 수 있고 한 번도 3으로 나눈 수에 방문한 적이 없으면
//			System.out.println("index" + index +"번째 3으로 나눔"+ answer);
			// 이전 리스트에다가 해당 리스트 숫자 넣기 
			arr[n/3] = arr[n];
			arr[n/3].add(n/3);
			
			if (n / 3 == 1) { // 1에 도착한 경우
				answer = Math.min(answer, index);
				return;
			} 
			start(n/3, index);
		}
		if(!arr[1].isEmpty())return;
			
		if (n % 2 == 0 && arr[n / 2].isEmpty()) {// 2으로 나눌 수 있고 한 번도 2으로 나눈 수에 방문한 적이 없으면
//			System.out.println("index" + index +"번째 2로 나눔"+answer);
			arr[n/2] = arr[n];
			arr[n/2].add(n/2);
			if (n / 2 == 1) {
				answer = Math.min(answer, index);
				return;
			} 
			start(n/2, index);
		}

		if(!arr[1].isEmpty())return;
		if (n > 0 && arr[n - 1].isEmpty()) {
//			System.out.println("index" + index +"번째 1로 뺌"+answer);
			arr[n-1] = arr[n];
			arr[n-1].add(n-1);
			if (n - 1 == 1) {
				answer = Math.min(answer, index);
				return;
			} 
			start(n-1, index);
		}
		
	}
}
