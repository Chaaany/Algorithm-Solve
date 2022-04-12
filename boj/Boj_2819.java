package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2819 {
	static int N, M, checkPointX[], checkPointY[], robotLoc[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		StringBuilder sb = new StringBuilder();
		robotLoc = new int[2];
		robotLoc[0] = 0;
		robotLoc[1] = 0;
		checkPointX = new int[N];
		checkPointY = new int[N];

		long distance = 0;
		// 조사점

		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stz.nextToken());
			int c = Integer.parseInt(stz.nextToken());
			distance += Math.abs(r - 0) + Math.abs(c - 0);
			checkPointX[i] = r;
			checkPointY[i] = c;

		}

		Arrays.sort(checkPointX);
		Arrays.sort(checkPointY);
//		for (int i = 0; i < N; i++) {
//			System.out.println(checkPointX[i] + "," + checkPointY[i]);
//		}
		// 0 2 2 4 4 5 6
		// index = 1 -> 작은 건 이거 기준으로 해도 무방함
		// -1 0 2 3 4

		int xIndexForlt = lowerbound(checkPointX, 0, N, robotLoc[0]);
		int yIndexForlt = lowerbound(checkPointY, 0, N, robotLoc[1]);
		int xIndexForgt = upperbound(checkPointX, 0, N, robotLoc[0]);
		int yIndexForgt = upperbound(checkPointY, 0, N, robotLoc[1]);
		int ltXCnt = 0;
		int gtXCnt = 0;
		int ltYCnt = 0;
		int gtYCnt = 0;
		int sameXCnt = 0;
		int sameYCnt = 0;
//		System.out.println(xIndexForlt + " " + xIndexForgt + " " + yIndexForlt + " " + yIndexForgt);
		ltXCnt = xIndexForlt;
		gtXCnt = checkPointX.length - xIndexForgt;
		ltYCnt = yIndexForlt;
		gtYCnt = checkPointY.length - yIndexForgt;
		sameXCnt = checkPointX.length - (ltXCnt + gtXCnt);
		sameYCnt = checkPointY.length - (ltYCnt + gtYCnt);
//		System.out.println(
//				"이전 로봇보다 큰 X조사점 갯수 :" + gtXCnt + ", 로봇보다 작은 X조사점 갯수 :" + ltXCnt + ", 로봇과 같은 X조사점 갯수 :" + sameXCnt);
//		System.out.println(
//				"이전 로봇보다 큰 Y조사점 갯수 :" + gtYCnt + ", 로봇보다 작은 Y조사점 갯수 :" + ltYCnt + ", 로봇과 같은 Y조사점 갯수 :" + sameYCnt);

		String command = br.readLine();
		int index = 0;
		while (index < M) {
			switch (command.charAt(index++)) {
			case 'S':
				robotLoc[1]++; // y좌표 증가
				distance = distance - gtYCnt + ltYCnt + sameYCnt;
				break;
			case 'J':
				robotLoc[1]--; // y좌표 감소
				distance = distance + gtYCnt - ltYCnt + sameYCnt;

				break;
			case 'I':
				robotLoc[0]++; // x좌표 증가
				distance = distance - gtXCnt + ltXCnt + sameXCnt;

				break;
			case 'Z':
				robotLoc[0]--; // x좌표 감소
				distance = distance + gtXCnt - ltXCnt + sameXCnt;

				break;
			}

			xIndexForlt = lowerbound(checkPointX, 0, N, robotLoc[0]);
			yIndexForlt = lowerbound(checkPointY, 0, N, robotLoc[1]);
			xIndexForgt = upperbound(checkPointX, 0, N, robotLoc[0]);
			yIndexForgt = upperbound(checkPointY, 0, N, robotLoc[1]);
//			System.out.println(xIndexForlt + " " + xIndexForgt + " " + yIndexForlt + " " + yIndexForgt);
			ltXCnt = xIndexForlt;
			gtXCnt = checkPointX.length - xIndexForgt;
			ltYCnt = yIndexForlt;
			gtYCnt = checkPointY.length - yIndexForgt;
			sameXCnt = checkPointX.length - (ltXCnt + gtXCnt);
			sameYCnt = checkPointY.length - (ltYCnt + gtYCnt);
//			System.out.println("이후 로봇" + robotLoc[0]+" "+robotLoc[1]);
//			System.out.println(
//					"이후 로봇보다 큰 X조사점 갯수 :" + gtXCnt + ", 로봇보다 작은 X조사점 갯수 :" + ltXCnt + ", 로봇과 같은 X조사점 갯수 :" + sameXCnt);
//			System.out.println(
//					"이후 로봇보다 큰 Y조사점 갯수 :" + gtYCnt + ", 로봇보다 작은 Y조사점 갯수 :" + ltYCnt + ", 로봇과 같은 Y조사점 갯수 :" + sameYCnt);

			sb.append(distance).append("\n");
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb);

	}

	private static int upperbound(int[] a, int fromIndex, int toIndex, int key) {
//		System.out.println("upper");
		while (fromIndex < toIndex) {
			int mid = (fromIndex + toIndex) >> 1;
			int midVal = a[mid];

			if (midVal > key)
				toIndex = mid;
			else
				fromIndex = mid + 1;
		}
		return fromIndex;
	}

	private static int lowerbound(int[] a, int fromIndex, int toIndex, int key) {
//		System.out.println("lower");
		while (fromIndex < toIndex) {
			int mid = (fromIndex + toIndex) >> 1;
			int midVal = a[mid];

			if (midVal < key)
				fromIndex = mid + 1;
			else
				toIndex = mid;
		}
		return fromIndex;
	}
}
