package boj;

import java.util.Scanner;

public class Boj_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int arr[][] = new int[8][2];
		int maxWidth = 0;
		int maxHeight = 0;
		int tempWidth = 0;
		int tempHeight = 0;

		for (int i = 1; i < 7; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			if (arr[i][0] < 3) {
				maxWidth = Math.max(arr[i][1], maxWidth);
			} else {
				maxHeight = Math.max(arr[i][1], maxHeight);
			}
		}
		arr[0][0] = arr[6][0];
		arr[0][1] = arr[6][1];
		arr[7][0] = arr[1][0];
		arr[7][1] = arr[1][1];

		for (int i = 1; i < 7; i++) {
			if (arr[i - 1][0] == arr[i + 1][0] && arr[i][0] < 3) {
				tempWidth = arr[i][1];
			} else if (arr[i - 1][0] == arr[i + 1][0] && arr[i][0] >= 3) {
				tempHeight = arr[i][1];
			}
		}
		System.out.println((maxWidth * maxHeight - tempWidth * tempHeight) * count);
		sc.close();
	}
}
