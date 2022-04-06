package jg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class jg_2577_회전초밥 {
	public static void main(String[] args) throws IOException {
//		회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c가 
//		각각 하나의 빈 칸을 사이에 두고 주어진다. 단, 2≤N≤3,000,000, 2≤d≤3,000, 2≤k≤3,000 (k≤N), 1≤c≤d이다. 
//		7	9	7	30	2	7	9	25
//		O	O	O	O
//			O	O	O	O
//				O	O	O	O
//					O	O	O	O
//						O	O	O	O
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int answer = 0;
		int N = Integer.parseInt(stz.nextToken());
		int d = Integer.parseInt(stz.nextToken());
		int k = Integer.parseInt(stz.nextToken());
		int c = Integer.parseInt(stz.nextToken());
		int sushiCnt = 0;
		int visited[] = new int[3001];
		
		int arr[] = new int[N];
		for (int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int l = 0;
		int r = k-1;
		for (int i = 0; i <= r; i++) {
			if(visited[arr[i]] == 0) {// 안 먹은 초밥 종류면 갯수 카운팅
				sushiCnt++;
				visited[arr[i]]++;
//				System.out.println(arr[i]);
			}else {
				visited[arr[i]]++; // 먹은 초밥 종류면 갯수 늘림
			}
		}
		if(visited[c] == 0) {
			sushiCnt++; // 쿠폰으로 받을 수 있는 초밥 안 먹었으면 갯수 늘림
			answer = sushiCnt; //임시 답안
			sushiCnt--;
		}else {
			answer = sushiCnt;
		}
		
		
		while(l < N) { // 회전 테이블의 끝까지 돈다.
			visited[arr[l]]--; // 왼쪽 포인터 움직이면서 초밥 갯수 줄이기
			if(visited[arr[l]] == 0) { // 제외하려는 왼쪽포인터가 유일하게 먹은 초밥이라면
				sushiCnt--;
//				System.out.println(sushiCnt);
			}
			l++;
//			System.out.print("l 이" + l +"이고 ");
			
			r++;// 오른쪽 포인터 움직임
//			System.out.print("r이 " + r + "일 때 ");
			if(visited[arr[r%N]] == 0) { // 오른쪽에 있는 회전 초밥 처음 먹어보는 종류라면
				sushiCnt++; 
				visited[arr[r%N]]++;
			}else {// 처음이 아니라면
				visited[arr[r%N]]++;
			}
//			System.out.print(sushiCnt+"\n");
			if(visited[c] == 0) {// 쿠폰번호 찍힌 초밥 먹게해줌 
				sushiCnt++; // 쿠폰번호 찍힌 초밥 먹게해줌
				answer = Math.max(answer, sushiCnt);
				sushiCnt--;// 그다음번 횟수엔 포함 안시킴
			} else {// 쿠폰 번호 찍힌 초밥 이미 먹은 적 있으면
				answer = Math.max(answer, sushiCnt);
			}
			if(answer == k+1)break;
		}
		System.out.println(answer);
			
	}
}
