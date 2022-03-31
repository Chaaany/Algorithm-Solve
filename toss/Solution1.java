package toss;

public class Solution1 {//17분소요

	public static int[] solution(int money, int limit) {
        int[] answer = new int[2];
        int m = money;
        int l = limit;
        int Scount = 0;
        int Fcount = 0;
        int ComboCount = 0;
        int index = 1;
//        단, 첫 송금에 성공하거나, 송금을 두 번 연속 성공하거나, 1원 송금에 실패하면 작업을 종료합니다.
        while(true) {
        	if(m - l  >= 0) { // 송금에 성공한 경우
        		if(index == 1) { // 첫 번 째 시도에  성공한 경우
        			Scount++;
        			break;
        		}
//        		첫 번 째 시도가 아닌 경우
        		if(ComboCount == 1) {//연속으로 두 번 성공한 경우
        			Scount++;
        			break;
        		}else { // 첫 번째 시도가 아니면서 처음 성공한 경우
        			m = m - l; // 송금한 금액 제외
        			Scount++; // 성공한 횟수 증가
        			ComboCount++; // 콤보 횟수 증가
        			index++;  // 인덱스 증가
        			continue;
        		}
        	} else { 
        		//송금에 실패한 경우
        		// 송금 실패한 금액이 1원일 경우
        		if(l == 1) {
        			Fcount++; // 실패한 횟수 증가 후 끝내기
        			break;
        		} 
        		ComboCount = 0; // 콤보 초기화
        		l /= 2; // 송금 실패 했으므로 2로 나눠주기
        		Fcount++; // 실패한 횟수 증가
        		index++; // 인덱스 증가시켜주기 
        	}
        }
        
        answer[0] = Scount;
        answer[1] = Fcount;
        
        return answer;
    }

	public static void main(String[] args) {
		int ans[] = Solution1.solution(3, 5);
		int ans1[] = Solution1.solution(3, 5);
		int ans2[] = Solution1.solution(3, 5);
		int ans3[] = Solution1.solution(3, 5);
		System.out.println(ans[0] + " " + ans[1]);
	}
}
