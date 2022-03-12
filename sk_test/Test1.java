package sk_test;

public class Test1 {

	public int solution(int money, int[] costs) {
		int answer = 0;
		
		costs[1] = costs[0]* 5 < costs[1] ? costs[0]*5 : costs[1]; // 1 vs 5
		costs[2] = costs[1]* 2 < costs[2] ? costs[1]*2 : costs[2]; // 5 vs 10
		costs[3] = costs[2]* 5 < costs[3] ? costs[2]*5 : costs[3]; // 10 vs 50
		costs[4] = costs[3]* 2 < costs[4] ? costs[3]*2 : costs[4]; // 50 vs 100
		costs[5] = costs[4]* 5 < costs[5] ? costs[4]*5 : costs[5]; // 100 vs 500
		
		
		if(money / 500 != 0) {
			answer += money/500 * costs[5];
			money %= 500;
		}
		
		if(money / 100 != 0) {
			answer += money/100 * costs[4];
			money %= 100;
		}
		
		if(money / 50 != 0) {
			answer += money/50 * costs[3];
			money %= 50;
		}
		
		if(money / 10 != 0) {
			answer += money/10 * costs[2];
			money %= 10;
		}
		
		if(money / 5 != 0) {
			answer += money/5 * costs[1];
			money %= 5;
		}
		
		if(money / 1 != 0) {
			answer += money/1 * costs[0];
		}
		
		return answer;
	}

}
