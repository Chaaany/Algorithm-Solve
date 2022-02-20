package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임 {

	static int[] cardNumber, K, I, check, cardArr, result; // 0 = 규영 승 , 1 = 인영 승
	static int cardCheck;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		cardNumber = new int[18];
		;
		for (int i = 1; i <= 18; i++) {
			cardNumber[i - 1] = i;
		}

		for (int t = 1; t <= T; t++) {
			result = new int[2];
			K = new int[9];
			I = new int[9];
			check = new int[19];
			visited = new boolean[9];
			cardArr = new int[9];
			stz = new StringTokenizer(br.readLine());
			for (int i = 0; i < K.length; i++) {
				K[i] = Integer.parseInt(stz.nextToken());
				check[K[i]] = 1;
			}
			int cnt = 0;
			for (int i = 1; i <= 18; i++) {
				if (check[i] == 1)
					continue;
				I[cnt++] = i;
			}

			perm(0);
			
			sb.append("#"+t+" "+result[0]+" "+result[1]+"\n");
		}
		System.out.println(sb);
	}

	private static void perm(int cardCnt) {
		if (cardCnt == 9) {
			play(K, cardArr);
			return;
		}

		for (int i = 0; i < I.length; i++) {

			if (visited[i])
				continue;

			visited[i] = true;
			cardArr[cardCnt] = I[i];
			perm(cardCnt + 1);
			visited[i] = false;
		}
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
