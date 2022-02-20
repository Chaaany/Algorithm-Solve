package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임_prevPerm {

	static int[] cardNumber, K, I, check, result; // 0 = 규영 승 , 1 = 인영 승

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		cardNumber = new int[18];
		result = new int[2];
		K = new int[9];
		I = new int[9];
		check = new int[19];

		for (int i = 1; i <= 18; i++) {
			cardNumber[i - 1] = i;
		}

		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(br.readLine());

			for (int i = 0; i < K.length; i++) {
				K[i] = Integer.parseInt(stz.nextToken());
				check[K[i]] = 1;
			}
			for (int i = 18, j = 0; i >= 1; i--) {
				if (check[i] == 1) {
					check[i] = 0;
					continue;
				}
				I[j++] = i;
			}

			do {
				play(K, I);
			} while (np(I.length - 1));

			sb.append("#").append(t).append(" ").append(result[0]).append(" ").append(result[1]).append("\n");
			result[0] = 0;
			result[1] = 0;
		}
		System.out.print(sb);
	}

	private static boolean np(int size) {
		int i = size;

		while (i > 0 && I[i - 1] <= I[i])
			i--;

		if (i == 0)
			return false;

		int j = size;

		while (i <= j && I[i - 1] <= I[j])
			j--;

		swap(i - 1, j);

		j = size;
		
		while (i < j) {
			swap(i++, j--);
		}

		return true;
	}

	private static void swap(int a, int b) {
		int temp = I[a];
		I[a] = I[b];
		I[b] = temp;
	}

	private static void play(int[] kCarArr, int[] inCarArr) {
		int inScore = 0, kScore = 0;

		for (int i = 0; i < 9; i++) {
			if (inCarArr[i] > kCarArr[i]) {
				inScore += inCarArr[i] + kCarArr[i];
			} else if (inCarArr[i] < kCarArr[i]) {
				kScore += inCarArr[i] + kCarArr[i];
			}
		}

		if (inScore < kScore) {
			result[0]++;
		} else if (inScore > kScore) {
			result[1]++;
		}

		return;

	}
}
