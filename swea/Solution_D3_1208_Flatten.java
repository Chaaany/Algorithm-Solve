package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten {

	public static void main(String[] args) throws IOException {
		int max = -1;
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		int maxIndex = 0;
		int dumpCnt;
		int[] stickHeights = new int[100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			dumpCnt = Integer.parseInt(br.readLine());
			stz = new StringTokenizer(br.readLine());
			max = -1;
			min = Integer.MAX_VALUE;
			minIndex = -1;
			maxIndex = -1;
			for (int i = 0; i < 100; i++) {
				stickHeights[i] = Integer.parseInt(stz.nextToken());
			} // 입력

			while (dumpCnt-- > 0) {
				max = -1;
				min = Integer.MAX_VALUE;
				minIndex = -1;
				maxIndex = -1;
				for (int i = 0; i < stickHeights.length; i++) {
					min = Math.min(min, stickHeights[i]);
					minIndex = stickHeights[i] == min ? i : minIndex;
					max = Math.max(max, stickHeights[i]);
					maxIndex = stickHeights[i] == max ? i : maxIndex;
				}
				if (max - min <= 1) {
					break;
				} else {
					stickHeights[minIndex]++;
					stickHeights[maxIndex]--;
				}
			}
			max = -1;
			min = Integer.MAX_VALUE;
			minIndex = -1;
			maxIndex = -1;
			for (int i = 0; i < stickHeights.length; i++) {
				min = Math.min(min, stickHeights[i]);
				minIndex = stickHeights[i] == min ? i : minIndex;
				max = Math.max(max, stickHeights[i]);
				maxIndex = stickHeights[i] == max ? i : maxIndex;
			}
			sb.append("#" + t + " " + (max - min)+"\n");
		}
		System.out.println(sb);

	}
}