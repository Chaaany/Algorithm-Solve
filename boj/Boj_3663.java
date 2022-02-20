package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3663 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String a = br.readLine();
			sb.append(solution(a)+"\n");
		}
		System.out.println(sb);
		
	}
	
	 
	public static int solution(String name)
	{
	    int answer = 0;
	    int shift = name.length() - 1; //커서를 좌 또는 우 한 쪽 방향만으로 이동했을 때
	    for(int i = 0; i < name.length(); i++)
	    {
	        if(name.charAt(i) == 'A')
	        {
	            int target = i;
	            while(target < name.length() && name.charAt(target) == 'A') 
	            	target += 1; //A로만 이루어진 문자열 찾기
	            int left = i == 0 ? 0 : i - 1; //찾은 문자열 왼쪽에서의 이동횟수
	            int right = name.length() - target;  //찾은 문자열 오른쪽에서의 이동횟수
	            shift = Math.min(shift, left + right + Math.min(left, right)); //가장 작은값 찾기
	        }
	    }
	    answer += shift;
	    for(int i = 0; i < name.length(); i++) 
	    	answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); //상하 이동횟수
	    return answer;
	}
}
