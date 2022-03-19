package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1.가로, 세로 각각 9개씩 총 81개 정사각형 판  int[9][9]
// 2.1부터 9까지의 숫자 중 하나가 쓰여 있다. 
// 3.각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다. 가로, 세로줄 확인 -> 매번 확인 해야 할까?
// 4.굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다. 해당 숫자의 3x3 확인 -> 매번 확인 해야 할까?
// 메서드
// checkR(int r, int number) : 행 기준 해당 숫자가 이미 사용된 숫자인지 확인
// checkC(int c, int number) : 열 기준 해당 숫자가 이미 사용된 숫자인지 확인
// checkT(int r, int c, int n) : 9사분면 중 r,c가 속한 사분면에서 이미 사용된 숫자인지 확인 // 3으로 나눈 몫 기준 9사분면 가능  0~2 / 3~5/ 6~8

// baekjoon의 백트래킹 알고리즘으로 풀 수 있는 입력만 주어진다. 다음은 그 알고리즘의 수행 시간이다. 백트래킹 사용하기-
// Java: 292ms = 2920만번 가능

public class Boj_2580 {
	static int arr[][] = new int[10][10]; // 스도쿠판
	static boolean vR[][] = new boolean[10][10]; // 가로 방문 체크
	static boolean vC[][] = new boolean[10][10]; // 세로 방문 체크
	static boolean vT[][][] = new boolean[3][3][10]; // 사분면 방문 체크
	static int nums[]; // 채워야하는 숫자 최대 81개
	static int zeroarr[][] = new int[81][2]; // 채워야 하는 숫자의 좌표
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;

		int index = 0;
		for (int i = 1; i <= 9; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				arr[i][j] = Integer.parseInt(stz.nextToken());
				if (arr[i][j] == 0) { // 숫자 채워넣어야 할 리스트에 넣기
					zeroarr[index][0] = i;
					zeroarr[index++][1] = j;
				} else {
					vR[i][arr[i][j]] = true; // 행 기준 사용한 숫자 처리
					vC[j][arr[i][j]] = true; // 열 기준 사용한 숫자 처리
					vT[changeT(i)][changeT(j)][arr[i][j]] = true; // 사분면 기준 사용한 숫자 처리
				}
			}
		}

		perm(0, index); // 숫자 대입하기

	}

	private static void perm(int cnt, int targetN) {
		if (cnt == targetN) { // 숫자 다 채웠음
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			return;
		}
		int r = zeroarr[cnt][0]; // 탐색해야할 r좌표
		int c = zeroarr[cnt][1]; // 탐색해야할 r좌표

		for (int i = 1; i <= 9; i++) {
			if (!vR[r][i] && !vC[c][i] && !vT[changeT(r)][changeT(c)][i]) { // 넣을 수 있는 숫자 식별
				arr[r][c] = i;
				vR[r][i] = true;
				vC[c][i] = true;
				vT[changeT(r)][changeT(c)][i] = true;
				perm(cnt + 1, targetN);
				// 미사용 처리
				if (cnt != targetN - 1) {
					arr[r][c] = 0; // 굳이 할 필욘 없음
					vR[r][i] = false;
					vC[c][i] = false;
					vT[changeT(r)][changeT(c)][i] = false;
				}
			}
		}
	}

	private static int changeT(int nums) { // 사분면으로 변환해 주는 함수
		return (nums - 1) / 3;
	}
}
