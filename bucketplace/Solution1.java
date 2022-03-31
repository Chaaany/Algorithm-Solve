package bucketplace;

class Solution1 {
    public static int solution(String[][] rounds) {
        int answer = -1;
        int cnt = 0;
        boolean[] couple = new boolean[4];
        String[] chr = { "a", "b", "c", "d"};

        for(int i = 0; i < rounds.length; i++){
            for(int j = 0; j < rounds[i].length; j++){
                if(rounds[i][j].equals(chr[j])){
                    cnt++;
                    if(couple[j]){
                        couple[j] = false;
                    }
                    continue;
                }	
                if(chr[j] == rounds[i][rounds[i][j].charAt(0) - 'a']){
                    if(i == 0) {
                        couple[j] = true;
                        continue;
                    }

                    if(couple[j] && rounds[i-1][j] == rounds[i][j]){
                        cnt++;
                        continue;
                    }
                    couple[j] = true;

                } else {
                    if(i == 0) continue;
                    if(rounds[i][j] == rounds[i-1][j] && couple[j]){
                        cnt++;
                        couple[j] = false;
                    }
                }
            }
        }
        answer = cnt;
        return answer;
    }
    
	public static void main(String[] args) {
		System.out.println(Solution1.solution(new String[][] {{"b", "a", "a", "d"}, {"b", "c", "a", "c"}, {"b", "a", "d", "c"}}));
		System.out.println(Solution1.solution(new String[][] {{"b", "a", "d", "c"},{"b", "a", "c", "d"}}));
		System.out.println(Solution1.solution(new String[][] {{"b", "a", "d", "c"},{"d", "c", "b", "a"},{"b", "a", "d", "c"}}));
		System.out.println(Solution1.solution(new String[][] {{"d", "a", "a", "a"},{"c", "a", "a", "a"},{"b", "a", "a", "a"}}));
	}
}

