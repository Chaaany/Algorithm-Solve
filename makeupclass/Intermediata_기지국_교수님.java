package makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author 윤병찬
 *
 */
public class Intermediata_기지국_교수님 {
	static BufferedReader input;
	static StringBuilder output;
	static int N, T;
	static char[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {

		input = new BufferedReader(new StringReader(src)); // 테케 붙여넣기 귀찮음\
		output = new StringBuilder();
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new char[N][];
			for (int r = 0; r < N; r++) {
				map[r] = input.readLine().toCharArray();
			}
//			입력확인!!
//			for (char[] row :  map) {
//				System.out.println(Arrays.toString(row));
//			}
//			
//			i, j
//			2차원 배열 탐색 - 좌표계를 명확히 해두세요!

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					if(map[r][c]<'D') {
						check(r, c, map[r][c]-'A'+1);
					}
//					if (map[r][c] == 'A') { // 사방으로 1칸씩 탐색
//						check(r, c, 1);
//
//					} else if (map[r][c] == 'B') { // 사방으로 2칸씩 탐색
//						check(r, c, 2);
//
//					} else if (map[r][c] == 'B') { // 사방으로 3칸씩 탐색
//						check(r, c, 3);
//
//					}
				}

			}
			
			int answer = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] =='H') {
						answer++;
					}
				}
			}
			output.append(String.format("#%d %d%n", t, answer));
		}
		System.out.println(output);
	}

	private static void check(int r, int c, int l) {
		for (int d = 0; d < 4; d++) {
			for (int i = 1; i <= l; i++) {
				int nr = r + deltas[d][0]*i;
				int nc = c + deltas[d][1]*i;

				if (isIn(nr, nc) && map[nr][nc] == 'H') {
					map[nr][nc] = 'X';
				}
			}
		}
	}

	
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	public static String src = "10\r\n" + "5\r\n" + "XXXXX\r\n" + "XHXXX\r\n" + "HXAHX\r\n" + "XHHXX\r\n" + "XBHHX\r\n"
			+ "9\r\n" + "XXXXXXXXX\r\n" + "XXXHXXXXX\r\n" + "XXHAHXXHX\r\n" + "XXHHXXXXX\r\n" + "XXXXXXXXX\r\n"
			+ "XXAHHXXXX\r\n" + "XXHXXHAHX\r\n" + "XXAHXXHXX\r\n" + "XXHXHXXXX\r\n" + "9\r\n" + "XXXXXXXXX\r\n"
			+ "XXHHHXXXX\r\n" + "XXHAHXHXX\r\n" + "XXHHHXHXX\r\n" + "XXXHXXXXX\r\n" + "XXXBXXXXX\r\n" + "XXXXXXCHH\r\n"
			+ "XXXXXXXXX\r\n" + "XXXHXXHXX\r\n" + "10\r\n" + "XXXXXXXXXX\r\n" + "XXXHXXXXXX\r\n" + "XHXAHXXXXX\r\n"
			+ "XXXHXXHXXX\r\n" + "XXXHXXHXXX\r\n" + "XXBXXXHXXX\r\n" + "HXHHHHCHHH\r\n" + "XXHXXXHXXX\r\n"
			+ "XXXXXXHXXX\r\n" + "XXHXXXHXXX\r\n" + "10\r\n" + "XXXXXXXXXX\r\n" + "XXXXHXXXXX\r\n" + "XXHAHAXXXX\r\n"
			+ "XXXAHAXXXX\r\n" + "XXHBHHAXXX\r\n" + "XXHBACHXXX\r\n" + "BXXHBCXXXX\r\n" + "HAHCHHAXXX\r\n"
			+ "XXXXXHXXXX\r\n" + "XXXXXXXXXX\r\n" + "9\r\n" + "XXXXHXXXX\r\n" + "XXXXXXXXX\r\n" + "XHXXHXXXX\r\n"
			+ "XXXXXXXXX\r\n" + "XHXXHXXXX\r\n" + "XXXXHHXXH\r\n" + "XXXXXHXXX\r\n" + "XHXXXHXXX\r\n" + "XXXXXXXXX\r\n"
			+ "9\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n"
			+ "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "10\r\n" + "XAXXXCXXXX\r\n"
			+ "XBXCXAXXXX\r\n" + "XXXBACXXXX\r\n" + "XXXBBABXXX\r\n" + "XXXACXXXXX\r\n" + "XXXXXXAXXX\r\n"
			+ "XCXXXXBXXX\r\n" + "XXAXCXCXXX\r\n" + "XXXXXXXXXX\r\n" + "XXXXXXXXXX\r\n" + "10\r\n" + "ABABCABCAC\r\n"
			+ "BACABACBAC\r\n" + "ABCABCABAC\r\n" + "BACBAABCAB\r\n" + "ABBAABCABC\r\n" + "ABCBABCBAA\r\n"
			+ "ABBBAABCCA\r\n" + "ABBCCABCAB\r\n" + "ABBCAACBBC\r\n" + "ABBCCAACBA\r\n" + "10\r\n" + "HHHHHHHHHH\r\n"
			+ "ABCBABAABA\r\n" + "HHHHHHHHHH\r\n" + "ABCBABCCAB\r\n" + "HHHHHHHHHH\r\n" + "AABCAABBCA\r\n"
			+ "HHHHHHHHHH\r\n" + "BCABBCBCAC\r\n" + "HHHHHHHHHH\r\n" + "CABBCAACCB";
}
