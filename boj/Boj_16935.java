package boj;

import java.util.Scanner;

public class Boj_16935 {
	static int N, M, R, control;
	static int[][] arr;
	static int[][] answerArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < R; i++) { // 연산 R번 적용
			control = sc.nextInt();

			switch (control) { // 연산 6가지
			case 1:
				calc1();
				break;
				
			case 2:
				calc2();
				break;
			case 3:
				calc3();
				break;
			case 4:
				calc4();
				break;
			case 5:
				calc5();

				break;
			case 6:
				calc6();

				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void calc1() {
//		상하 반전
		int[] tempArr = new int[M + 2];

		for (int i = 1; i <= N / 2; i++) {
			for (int j = 1; j <= M; j++) {
				tempArr[j] = arr[N - i + 1][j];
				arr[N - i + 1][j] = arr[i][j];
				arr[i][j] = tempArr[j];
			}
		}

	}

	private static void calc2() {
//		좌우 반전
		int[] tempArr = new int[M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M / 2; j++) {
				tempArr[j] = arr[i][j];
				arr[i][j] = arr[i][M - j + 1];
				arr[i][M - j + 1] = tempArr[j];
			}
		}

	}

	private static void calc3() {
		// 90도 오른쪽 회전
		int[][] temp = new int[M + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp[j][N - i + 1] = arr[i][j];
			}
		}
		arr = temp;
		int tempValue = 0;
		tempValue = N;
		N = M;
		M = tempValue;

	}

	private static void calc4() {
		// 90도 오른쪽 회전
		int[][] temp = new int[M + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp[M - j + 1][i] = arr[i][j];
			}
		}
		arr = temp;
		int tempValue = 0;
		tempValue = N;
		N = M;
		M = tempValue;

	}

	private static void calc5() {
		int[][] temp = new int[N + 2][M + 2];
//		1 -> 2
		for (int i = 1; i <= N / 2; i++) {
			for (int j = 1; j <= M / 2; j++) {
				temp[i][j + M / 2] = arr[i][j];
			}
		}

//		2 -> 3
		for (int i = 1; i <= N / 2; i++) {
			for (int j = M / 2 + 1; j <= M; j++) {
				temp[i + N / 2][j] = arr[i][j];
			}
		}

//		3 -> 4 
		for (int i = N / 2 + 1; i <= N; i++) {
			for (int j = M / 2 + 1; j <= M; j++) {
				temp[i][j - M / 2] = arr[i][j];
			}
		}

//		4 -> 1
		for (int i = N / 2 + 1; i <= N; i++) {
			for (int j = 1; j <= M / 2; j++) {
				temp[i - N / 2][j] = arr[i][j];
			}
		}
		arr = temp;

	}

	private static void calc6() {
		int[][] temp = new int[N + 2][M + 2];
//		1 -> 4
		for (int i = 1; i <= N / 2; i++) {
			for (int j = 1; j <= M / 2; j++) {
				temp[i + N / 2][j] = arr[i][j];
			}
		}

//		4 -> 3
		for (int i = N / 2; i <= N; i++) {
			for (int j = 1; j <= M / 2; j++) {
				temp[i][j + M / 2] = arr[i][j];
			}
		}

//		3 -> 2
		for (int i = N / 2 + 1; i <= N; i++) {
			for (int j = M / 2 + 1; j <= M; j++) {
				temp[i - N / 2][j] = arr[i][j];
			}
		}

//		2 -> 1
		for (int i = 1; i <= N / 2; i++) {
			for (int j = M / 2 + 1; j <= M; j++) {
				temp[i][j - M / 2] = arr[i][j];
			}
		}
		arr = temp;
	}
}