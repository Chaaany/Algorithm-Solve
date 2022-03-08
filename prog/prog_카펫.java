package prog;

import java.util.Arrays;
import java.util.Scanner;

public class prog_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer= new int[2];
        
        int sum = brown + yellow;
        int h = 0;
        int w = 0;
        
        // h, w 구하기 (sum의 제곱근 이하까지)
        for (int i = 3; i <= sum; i++) {
			if(i*i > sum) break;
			if(sum % i == 0) {
				int tmpH = i;
				int tmpW = sum / i;
				if((tmpH-2)*(tmpW-2) == yellow) {
					h = tmpH;
					w = tmpW;
				}
			}
		}
        
    	answer[0] = w;
    	answer[1] = h;
        
        return answer;
        
        
    }
    
    
    
    
    
    public static void main(String[] args) {
    	prog_카펫 a = new prog_카펫();
    	int brown, yellow;
    	Scanner sc = new Scanner(System.in);
    	brown = sc.nextInt();
    	yellow = sc.nextInt();
    	System.out.println(Arrays.toString(a.solution(brown, yellow)));
	}
}
