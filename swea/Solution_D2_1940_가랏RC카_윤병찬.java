package swea;

import java.util.Scanner;

public class Solution_D2_1940_가랏RC카_윤병찬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int gear = 0;
			int speed = 0;
			int acceleration = 0;
			int runningDistance = 0;
			// 기어 0중립 기어 1 = 가속 / 기어 2 = 감속
			for (int i = 0; i < N; i++) {
				gear = sc.nextInt();
				if (gear != 0)
					acceleration = sc.nextInt();
				switch (gear) {
				case 0:
					runningDistance += speed;
					break;
				case 1:
					speed += acceleration;
					runningDistance += speed;
					break;
				case 2:
					if (speed < acceleration) {
						speed = 0;
					} else {
						speed -= acceleration;
						runningDistance += speed;
					}
					break;
				}
			}

			System.out.println("#" + t + " " + runningDistance);
		}

	}
}
