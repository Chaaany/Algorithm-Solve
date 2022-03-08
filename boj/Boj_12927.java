package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_12927 {

	static int T, N, cnt;
	static char arr[], tempArr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		cnt = 0;

		arr = br.readLine().toCharArray();
		char[] realArr = new char[arr.length + 1];
		for (int i = 1; i <= arr.length; i++) {
			realArr[i] = arr[i - 1];
		}

		tempArr = new char[realArr.length];
		Arrays.fill(tempArr, 'N');

		for (int i = 1; i < realArr.length; i++) {
			if (realArr[i] != tempArr[i]) { // 달라? 바꿔!
				char temp = realArr[i];
				for (int j = i; j < realArr.length; j += i) {
					if (tempArr[j] == 'Y') {
						tempArr[j] = 'N';
					} else {
						tempArr[j] = 'Y';
					}
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
