package boj;

import java.util.Scanner;

public class A_에어컨 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int normalT[] = {900, 1080, 1260};
		
		
		
		int memo[] = new int[N+1];
		
		// 같은 일인지 판단하는 방법 : 나눠서 몫이 같은 경우
		int index = 0;
		int day = 0;
		while(true) {
			for (int i = 0; i < normalT.length; i++) {
				if(normalT[i] / 1440 < 1) { // 1440 안쪽
					memo[day]++;
					if(memo[day] == 3) {
						
					}
				}else {
					memo[day+1]++;
				}
			}
		}
		
		System.out.println(memo[N]);
		
		
	}
}
