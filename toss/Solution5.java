package toss;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution5 {
	static int answer1 = 0;
	static int answer2 = 0;
	static int answer3 = 0;
	static char combiT;
	static boolean visited[][] = new boolean[26][10];
	static int[] nums;
	public static int solution(String[] cards) {
		int answer = -1;
		String[] deq = cards;
		TreeMap<Character, List<Integer>> CharToNum = new TreeMap<>();
		TreeMap<Integer, List<Character>> NumToChar = new TreeMap<>();
		char[] tempCArr = { 'S', 'C', 'D', 'H' };

		for (int i = 0; i < deq.length; i++) {
			char tempC = deq[i].charAt(0);
			int tempN = deq[i].charAt(1) - '0'; // 숫자화
			visited[tempC-'A'][tempN] = true;
			
			
			// CharToNum 넣기
			if (CharToNum.get(tempC) != null) { // 이미 들어간 문자?
				List<Integer> tempL = new ArrayList<>();
				tempL = CharToNum.get(tempC);
				tempL.add(tempN);
				CharToNum.put(tempC, tempL);
			} else { // 없는 문자?
				List<Integer> tempL = new ArrayList<>();
				tempL.add(tempN);
				CharToNum.put(tempC, tempL);
			}

			// NumToChar 넣기
			if (NumToChar.get(tempN) != null) { // 이미 들어간 문자?
				List<Character> tempL = new ArrayList<>();
				tempL = NumToChar.get(tempN);
				tempL.add(tempC);
				NumToChar.put(tempN, tempL);
			} else { // 없는 문자?
				List<Character> tempL = new ArrayList<>();
				tempL.add(tempC);
				NumToChar.put(tempN, tempL);
			}
		}

			// 같은 모양에서 3개 이상
			for (int i = 0; i < tempCArr.length; i++) {
				List<Integer> tempL = CharToNum.get(tempCArr[i]);
				if(tempL != null) {
					if(tempL.size()>=3) { // 점수 나올만함
						for (int k = tempL.size(); k >= 3; k--) {
							answer1 += nCr(tempL.size(), k) * k * k;
						}
					}
				}
			}
			// 같은 숫자 갯수 3개 이상
			for (int i = 0; i <= 9; i++) {
				List<Character> tempL = NumToChar.get(i);
				if(tempL != null) {
					if(tempL.size()>=3) { // 점수 나올만함
						for (int k = tempL.size(); k >= 3; k--) {
							answer2 += nCr(tempL.size(), k) * k * k;
						}
					}
				}
			}
			
			
			// 서로 다른 모양, 다른 숫자 갯수 3개 
//			nums = new int[3];
//			combi3(0, new boolean[10]);
			
			answer = answer1 + answer2 + answer3;

		return answer;
	}

	private static void combi3(int cnt, boolean[] visited) {
		if(cnt == 3) {
			for (int i = 0; i < nums.length; i++) {
				
			}
			return;
		}
	}

	public static int nCr(int n, int r) {
		if(n == r || r == 0) 
			return 1; 
		else 
			return nCr(n - 1, r - 1) + nCr(n - 1, r); 
	}




	public static void main(String[] args) {
		Solution5.solution(new String[] { "S1", "D3", "S3", "S4", "H3", "H1" });
	}
}
