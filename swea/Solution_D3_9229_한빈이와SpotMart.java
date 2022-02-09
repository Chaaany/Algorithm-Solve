package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와SpotMart {
	static int T, N, M, arr[], max, snacks[];
	static BufferedReader input;
	static StringBuilder output;
	static StringTokenizer stz;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(inputSrc));
		input = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder();
		int T = Integer.parseInt(input.readLine());// 테케 갯수
		for (int t = 1; t <= T; t++) {
			stz = new StringTokenizer(input.readLine(), " ");
			N = Integer.parseInt(stz.nextToken()); // 과자 갯수
			M = Integer.parseInt(stz.nextToken()); // 무게 제한
			snacks = new int[2];
			arr = new int[N];
			stz = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(stz.nextToken());
			} // 과자 무게 입력 완료
			max = -1;

			Arrays.sort(arr);// 과자배열 오름차순 정렬
			nCr(0, 0);
			output.append(String.format("#%d %d\n", t, max));
		}
		System.out.println(output);

	}

	private static void nCr(int cnt, int start) {
		if(cnt == 2) {
			if(snacks[0] + snacks[1] <= M)	max = max > snacks[0] + snacks[1] ? max : snacks[0] + snacks[1];
			return;
		}
		
		for (int i = start; i < N; i++) {
			snacks[cnt] = arr[i];
			nCr(cnt+1, i+1);
		}
		
	}

	static String inputSrc = "4\r\n" + "3 45\r\n" + "20 20 20\r\n" + "6 10\r\n" + "1 2 5 8 9 11\r\n" + "4 100\r\n"
			+ "80 80 60 60\r\n" + "4 20\r\n" + "10 5 10 16\r\n" + "";
	static String outputSrc = "#1 40\r\n" + "#2 10\r\n" + "#3 -1\r\n" + "#4 20\r\n" + "";

}
