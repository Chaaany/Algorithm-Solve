package prog;

import java.util.HashMap;

public class 여행경로 {
	static HashMap<String, Integer> hm = new HashMap<>(); 
	static String[] temp;
	public String[] solution(String[][] tickets) {
		String[] answer = {};
		temp = new String[tickets.length+1];
		for (int i = 0; i < answer.length; i++) {
			hm.put(tickets[i][1], i); // i번째 인덱스에 tickets[i][0]이 있다
		}
		
		dfs(0, );
		
		return answer;
	}
	private void dfs(int cnt, int N) {
		if(hm.containsKey())
		if(cnt == N) {
			return;
		}
	}

}
