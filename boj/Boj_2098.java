package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Boj_2098 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int N = Integer.parseInt(br.readLine());
		int[][] travelCost = new int[N][N];
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				travelCost[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		
		
		
		
	}

}

// 순회 여행 경로 구하기 & 최소 비용의 계획
// 조건
// 1. W[i][j] -> i->j  여행 경비
// 2. i -> j != j -> i 일수 있음 
// 3. i -> i == 0
// 4. i -> j 못 가는 경우 0

// 순열 문제 -> 순서에 영향을 받음
// + 특정 순서는 예외처리(특정 도시 -> 특정도시 0 일경우 제외)

// 0 0 
// 1 0 -> 여행 불가

// 1 -> 2 -> 1  // 15
// 2 -> 1 -> 2 // 15  2 개 도시 = 1 1 ! 

// 1 -> 2 -> 3 -> 1 // 10 + 9 + 6 = 25
// 2 -> 3 -> 1 -> 2 // 9 + 6 + 10 = 25
// 3 -> 1 -> 2 -> 3 // 6 + 10 + 9 = 25
//1 2 3 = 2 3 1 = 3 1 2

// 1 -> 3 ->  2 -> 1 // 15 + 13 + 5 = 33
// 2 -> 1 ->  3 -> 2 // 5 + 15 + 13 = 33
// 3 -> 2 ->  1 -> 3 // 13 + 5 + 15 = 33
//1 3 2 = 2 1 3 = 3 2 1 3개 도시 = 2 2! 

//4개 도시 -> 6개  3!

// 1 - 2 - 3 - 4
// 1 - 2 - 4  -3
// 1 - 3 - 2 - 4 
// 1 - 3 - 4 - 2
// 1 - 4 - 2 - 3
// 1 - 4 - 3 - 2

// 순서에 영향을 받는 것 같으나 다시 돌아와야 한다는 점에서 하나의 원과 같음

// 행렬의 곱 
// 2 ~ 16 -> 2! -> 16! -> 1초 초과 -> 최소비용? 

// 그리디 + 순열 
// 2 -> 1 -> 3 -> 4 -> 2 : 5 + 15 + 12 + 8 = 40

// 16 x 16 = 324 -> 2!-> 

// 