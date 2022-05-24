package kakao;

import java.util.Arrays;

class Solution {
  public static int[][] solution(int[][] rc, String[] operations) {
		int[][] answer = {};
		int cntRotate = 0;
		int cntShiftRow = 0;
		for (int i = 0; i < operations.length; i++) {
			if (operations[i].equals("Rotate")) {
				if(cntRotate == 0 && cntShiftRow == 0) {
					cntRotate++;
				}else if(cntRotate == 0 && cntShiftRow != 0) {
					cntShiftRow %= rc.length;
					for (int j = 0; j < cntShiftRow; j++) {
						ShiftRow(rc);
					}
					cntShiftRow = 0;
					cntRotate++;
				}else {
					cntRotate++;
				}
			} else {
				if(cntShiftRow == 0 && cntRotate == 0) {
					cntShiftRow++;
				}else if(cntShiftRow == 0 && cntRotate != 0) {
					cntShiftRow %= (rc.length + rc[0].length)*2-4;
					for (int j = 0; j < cntRotate; j++) {
						Rotate(rc);
					}
					cntRotate = 0;
					cntShiftRow++;
				}else {
					cntShiftRow++;
				}
			}
		}
		
		if(cntShiftRow != 0) {
			cntShiftRow %= rc.length;
			for (int j = 0; j < cntShiftRow; j++) {
				ShiftRow(rc);
			}
		}else if(cntRotate != 0) {
			cntShiftRow %= (rc.length + rc[0].length)*2-4;
			for (int j = 0; j < cntRotate; j++) {
				Rotate(rc);
			}
		}
		answer = rc;
		return answer;
	}

	private static void ShiftRow(int[][] rc) {
		int temp[] = Arrays.copyOf(rc[rc.length - 1], rc[rc.length - 1].length);
		for (int i = rc.length - 1; i > 0; i--) {
			rc[i] = Arrays.copyOf(rc[i - 1], rc[i - 1].length);
		}
		rc[0] = Arrays.copyOf(temp, temp.length);
	}

	private static void Rotate(int[][] rc) {
		int start = rc[0][0];
		int rowL = rc[0].length;
		int colL = rc.length;
		for (int j = 0; j < colL - 1; j++) {// 좌측
			rc[j][0] = rc[j + 1][0];
		}
		for (int j = 0; j < rowL - 1; j++) {// 하단
			rc[colL - 1][j] = rc[colL - 1][j + 1];
		}
		for (int j = colL - 1; j > 0; j--) {// 우측
			rc[j][rowL - 1] = rc[j - 1][rowL - 1];
		}
		for (int j = rowL - 1; j > 1; j--) {// 상단
			rc[0][j] = rc[0][j - 1];
		}
		rc[0][1] = start;
	}

	public static void main(String[] args) {

		int temp[][] = Solution5.solution(
				new int[][] { { 1, 2, 3, 111, 222, 333 }, { 4, 5, 6, 444, 555, 666 }, { 7, 8, 9, 777, 888, 999 } },
				new String[] { "Rotate", "Rotate" });

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}

	}
}
