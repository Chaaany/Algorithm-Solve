package kakao;

import java.util.TreeMap;

class Solution {
	public static String solution(String[] survey, int[] choices) {
		String answer = "";
		int score[] = new int[30];
		char[] charArr = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };
		for (int i = 0; i < choices.length; i++) {
			int choice = choices[i];
			switch (choice) {
			case 1:
				score[survey[i].charAt(0) - 'A'] += 3;
				break;
			case 2:
				score[survey[i].charAt(0) - 'A'] += 2;
				break;
			case 3:
				score[survey[i].charAt(0) - 'A'] += 1;
				break;
			case 4:
				break;
			case 5:
				score[survey[i].charAt(1) - 'A'] += 1;
				break;
			case 6:
				score[survey[i].charAt(1) - 'A'] += 2;
				break;
			case 7:
				score[survey[i].charAt(1) - 'A'] += 3;
				break;
			}
		}
		for (int j = 0; j < 8; j += 2) {
			if (score[charArr[j] - 'A'] >= score[charArr[j + 1] - 'A']) {
				answer += charArr[j];
			} else {
				answer += charArr[j + 1];
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Solution1.solution(new String[][] { { "b", "a", "a", "d" }, { "b", "c", "a", "c" }, { "b", "a", "d", "c" } }));
	}
}
