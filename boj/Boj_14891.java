package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14891 {
	static int T, K, arr[][], answer, magnetInfo[][];
	static List[] magnet;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 8개 짜리 List 4개 선언
		// 특정 톱니가 회전한다고 했을 때 주변 자석이 N, S극이 다른지 확인 -> 또 회전하였으면 주변 톱니 확인
		// 1 = 시계방향 0 0 1 -> 1 0 0 / -1 = 반시계방향 0 0 1 -> 0 1 0
		// N극 = 0, S극 = 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;

		magnet = new ArrayList[5]; // 0번째 안씀 -> 패딩
		magnetInfo = new int[5][2];
		visited = new boolean[5];
		// 자석 리스트 할당
		for (int i = 0; i < magnet.length; i++) {
			magnet[i] = new ArrayList<Integer>();
		}

		// 자석 리스트에 자성 할당
		for (int i = 1; i < magnet.length; i++) {
			String[] tempStr = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				magnet[i].add(Integer.parseInt(tempStr[j]));
				if (j == 2) {
					magnetInfo[i][0] = (int) magnet[i].get(j);
				} else if (j == 6) {
					magnetInfo[i][1] = (int) magnet[i].get(j);
				}
			}
//				System.out.println();
		}

		K = Integer.parseInt(br.readLine());
		arr = new int[K][2];
		// 회전할 자석과 방향 배열 할당
		for (int i = 0; i < K; i++) {
			stz = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = Integer.parseInt(stz.nextToken());
		}

		for (int i = 0; i < arr.length; i++) {
			start(arr[i][0], arr[i][1]);

//				System.out.println((i+1)+"번 째 결과");
//				for (int j = 1; j < magnet.length; j++) {
//					for (int k = 0; k < 8; k++) {
//						System.out.print(magnet[j].get(k)+" ");
//					}
//					System.out.println();
//				}
			updateInfo();

		}
		

		checkScore();
		System.out.println(answer);
	}

	private static void checkScore() {
		answer = 0;
		for (int i = 1; i < magnet.length; i++) {
			answer += (int) magnet[i].get(0) * (int) Math.pow(2, i - 1);
		}
	}

	private static void updateInfo() {
		for (int i = 1; i < magnet.length; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 2) {
					magnetInfo[i][0] = (int) magnet[i].get(j);
				} else if (j == 6) {
					magnetInfo[i][1] = (int) magnet[i].get(j);
				}
			}
		}
		for (int i = 1; i < 5; i++) {
			visited[i] = false;
		}
	}

	private static void start(int magnetNumber, int rotationDirection) {
		if (visited[magnetNumber])
			return; // 이미 확인한 톱니바퀴 컷!
		visited[magnetNumber] = true;

		int rightMagnet = magnetInfo[magnetNumber][0];
		int leftMagnet = magnetInfo[magnetNumber][1];

		if (rotationDirection == -1) { // -1 = 반시계방향 0 0 1 -> 0 1 0
			int temp = (int) magnet[magnetNumber].get(0);
			magnet[magnetNumber].remove(0);
			magnet[magnetNumber].add(temp);
		} else {// 1 = 시계방향 0 0 1 -> 1 0 0
//			System.out.println(magnetNumber);
//			System.out.println(magnet[magnetNumber]);
			int temp = (int) magnet[magnetNumber].get(7);
			magnet[magnetNumber].remove(7);
			magnet[magnetNumber].add(0, temp);
		}

		if (magnetNumber == 1) { // 두 번 째 자석 확인하기
			if (rightMagnet != magnetInfo[magnetNumber + 1][1]) { // 다른 극이였을 경우
				start(2, rotationDirection * -1);
			}

		} else if (magnetNumber == 4) { // 세 번 째 자석 확인하기
			if (leftMagnet != magnetInfo[magnetNumber - 1][0]) { // 다른 극이였을 경우
				start(3, rotationDirection * -1);
			}
		} else { // 양쪽 자석 확인하기
			// 왼쪽확인
			if (leftMagnet != magnetInfo[magnetNumber - 1][0]) { // 다른 극이였을 경우
				start(magnetNumber - 1, rotationDirection * -1);
			}
			// 오른쪽확인
			if (rightMagnet != magnetInfo[magnetNumber + 1][1]) { // 다른 극이였을 경우
				start(magnetNumber + 1, rotationDirection * -1);
			}
		}

	}

}
