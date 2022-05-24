package kakao;

import java.util.Arrays;
import java.util.Comparator;

class Solution3 {
	static int curAlp, curCop;

	public static int solution(int alp, int cop, int[][] problems) {

		int answer = 0;
		int time = 0;
		curAlp = alp;
		curCop = cop;
		// 문제 정렬
		Arrays.sort(problems, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		int targetIndex = -1;
		while (true) {
			// 수단 선택
			int ability[][] = new int[2][3];
			ability = checkAbility(problems);

			// 목표 설정
			targetIndex = Target(ability, problems);
			if (targetIndex == -1)
				break; // 풀 문제 없으면 종료

			// 풀 문제를 향해 공부 or 문제 풀기 시작
			time += checkShortM(ability, targetIndex, problems); // 제일 짧게 해당 문제 풀 수 있게 되는 시간 체크
		}
		answer = time;
		return answer;
	}

	private static int checkShortM(int[][] ability, int targetIndex, int[][] problems) {
		int minTime = 20000000;
		int minIndex = -1;
		if(ability == null) { // 열심히 시간과 맞바꿀 경우
			int time = Math.min(problems[targetIndex][0]-curAlp, problems[targetIndex][1]-curCop);
			if(problems[targetIndex][0]-curAlp >= problems[targetIndex][1]-curCop ) {
				curCop += problems[targetIndex][1]-curCop;
				return problems[targetIndex][1]-curCop;
			}else {
				curAlp += problems[targetIndex][0]-curAlp;
				return problems[targetIndex][0]-curAlp;
			}
		}else {
			for (int i = 0; i < ability.length; i++) {
				//알고 맞추기
				if(problems[targetIndex][0]-curAlp != 0) {
					
				}else if(problems[targetIndex][1]-curCop != 0) {
					
				}else if(problems[targetIndex][0]-curAlp == 0){
					int time = (int) (Math.ceil(1.0 * (problems[targetIndex][1] - curCop) / ability[i][1]))* ability[i][2];
					curCop += time / 
					return time;
				}else if(problems[targetIndex][1]-curCop == 0) {
					
				}
				//구현 맞추기
			}
		curAlp += ability[minIndex][0] * minTime / ability[minIndex][2];
		curCop += ability[minIndex][1] * minTime / ability[minIndex][2];
		return minTime;
		}
	}

	private static int[][] checkAbility(int[][] problems) {
		int maxAlpIndex = -1;
		int maxCopIndex = -1;
		int maxAlp_rwd = 0;
		int maxCop_rwd = 0;

		for (int i = 0; i < problems.length; i++) {
			int alp_req = problems[i][0];
			int cop_req = problems[i][1];
			int alp_rwd = problems[i][2];
			int cop_rwd = problems[i][3];
			int cost = problems[i][4];
			if (curAlp >= alp_req && curCop >= cop_req && (alp_rwd >= cost || cop_rwd >= cost)) { // 풀만한 문제 있는지 탐색
				if (1.0 * alp_rwd / cost > maxAlp_rwd) {
					maxAlp_rwd = alp_rwd;
					maxAlpIndex = i;
				}
				;
				if (1.0 * cop_rwd / cost > maxCop_rwd) {
					maxCop_rwd = cop_rwd;
					maxCopIndex = i;
				}
				;
			}
		}
		if (maxAlpIndex == -1 && maxCopIndex == -1) {
			return null; // 시간과 맞바꾸기
		} else {
			return new int[][] { { maxAlp_rwd, problems[maxAlpIndex][3], problems[maxAlpIndex][4] },
					{ problems[maxCopIndex][2], maxCop_rwd, problems[maxCopIndex][4] },
					};
		}
	}

	private static int Target(int ability[][], int[][] problems) {
		int req = 20000000;
		int index = -1;
		for (int i = 0; i < problems.length; i++) {
			int alp_req = problems[i][0];
			int cop_req = problems[i][1];
			int alp_rwd = problems[i][2];
			int cop_rwd = problems[i][3];
			int cost = problems[i][4];
			if (curAlp < alp_req || curCop < cop_req) {
				int temp = alp_req - curAlp + cop_req - curCop;
				if (temp < req) {
					req = temp;
					index = i;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
//		System.out.println(Solution3.solution(10, 10, new int[][] { { 10, 15, 2, 1, 2 }, { 20, 20, 3, 3, 4 } }));
		System.out.println(Solution3.solution(0, 0,
				new int[][] { { 0, 0, 2, 1, 2 }, { 4, 5, 3, 1, 2 }, { 4, 11, 4, 0, 2 }, { 10, 4, 0, 4, 2 } }));

	}
}
