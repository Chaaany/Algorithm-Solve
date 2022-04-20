package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780 {
	static int N, arr[][], count[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N x N 크기 행렬 / 1 <= N <= 3^7
		// -1, 0, 1 중에 하나 저장
		// 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
		// 2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
		// -> 모두 같은 수로 되어 있는 지 확인하는 메서드 -> 맨 첫 번째 확인 원소랑 같은지 확인
		// -> 종이를 자르는 메서드 -> n/3씩 자르기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		count = new int[3]; // 0 - -1, 1 - 0, 2 - 1 
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		
		check(0, 0, N);
		
		for (int answer : count) {
			System.out.println(answer);
		}
		
		
	}
	private static void check(int r, int c, int size) {
		// base condition
		if(size <= 1) { // 더 이상 나눌 수 없는 종이일 때는 각각 갯수 세기 
			if(arr[r][c] == -1) {
				count[0]++;
			}else if(arr[r][c] == 0) {
				count[1]++;
			}else {
				count[2]++;
			}
			return;
		}
		
		int number = arr[r][c]; // 기준 숫자
		boolean isSameNumber = true;
		
		a : for (int i = r; i < r+size ; i++) {
			for (int j = c; j < c+size; j++) {
				if(number != arr[i][j]) {
					isSameNumber = false;
					break a;
				}
			}
		}
		
		if(isSameNumber) {
			if(number == -1) {
				count[0]++;
			}else if(number == 0) {
				count[1]++;
			}else {
				count[2]++;
			}
		}else {
			int slicedSize = size/3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					check(r+slicedSize*i, c+slicedSize*j, slicedSize);
				}
			}
		}
		
	}
}
