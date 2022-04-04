package prog;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        int i = 0;
        int j = 1000000000;
        while(i <= j) {
        	int mid = (i + j) /2;
        	int total = 0;
        	for (int k = 0; k < times.length; k++) {
				total += mid / times[k];
			}
        	
        	if(total >= n) {
        		j = mid-1;
        		answer = mid;
        	}else {
        		i = mid+1;
        	}
        }
        
        return answer;
    }
}
