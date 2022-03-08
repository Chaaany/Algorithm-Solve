package prog;

public class 단어변환 {
	static String[] temp;
	static int min;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        temp = new String[words.length];
        
        perm(0, new boolean[words.length], words.length, target, words);
        return answer;
        
    }

	private void perm(int cnt, boolean[] visited, int N, String target, String[] words) {
		if(cnt != 0 && temp[cnt-1] == target) {
			min = Math.min(min, cnt);
			return;
		}
			
		if(cnt == N) {
			if(temp[cnt-1] == target)
			min = Math.min(min, cnt);
			return;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if(visited[i])continue;
			
			if(check[i])continue;
			
			temp[cnt] = words[i];
			visited[i] = true;
	        perm(cnt+1, new boolean[words.length], words.length, target, words);
	        visited[i] = false;
			
		}
	}
}
