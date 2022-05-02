import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Algo1_서울_15반_윤병찬 {

	public static void main(String[] args) {
		// 숫자별 영어
		Scanner sc = new Scanner(System.in); // M, N을 입력받을 스캐너
		int M = sc.nextInt(); // M 입력 받기
		int N = sc.nextInt(); // N 입력 받기
		String[] numToStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; // 숫자를 영어표기로 바꿀 배열
		TreeMap<String, String> strToNum = new TreeMap<>(); // 숫자에 해당하는 영문 표기 맵 선언
		for (int i = 0; i < numToStr.length; i++) {// 숫자를 영문 표기로 변환하기 위한 맵 key-value 할당
			strToNum.put(numToStr[i], String.valueOf(i));
		}
		String[] temp = new String[N-M+1]; // 사전 순 정렬할 배열 선언 
	
		for (int i = M, index = 0; i <= N; i++, index++) {
			String Number = String.valueOf(i); // int형을 String형으로 변환한 임시변수
			String tempNumToStr = ""; // 숫자를 문자로 변환하여 배열에 저장할 변수 
			for (int j = 0; j < Number.length(); j++) { // 숫자를 영어 표기법으로 변환하기 위한 임시변수에 값 할당
				tempNumToStr += numToStr[Number.charAt(j)-'0']+" ";
			}
			temp[index] =tempNumToStr; // 숫자를 영어 표기법으로 변환한 값을 임시 배열에 저장
		}
		
		Arrays.sort(temp); // String 형을 사전 오름차 순으로 정렬
		for (int i = 0; i < temp.length; i++) { // 오름차 순으로 정렬된 영문표기들을 숫자로 재변환 후 출력
			String[] tmp = temp[i].split(" "); // 띄어쓰기를 기준으로 영문표기를 숫자로 변환할 임시변수 할당
			String answer = ""; // 영문 표기를 숫자로 변환한 값 할당할 변수 선언
			for (int j = 0; j < tmp.length; j++) {
				answer+= strToNum.get(tmp[j]); // 영문 표기를 숫자로 변환
			}
			System.out.print(answer+" "); // 변환된 숫자를 출력
			if((i+1) % 10 == 0) { // 10씩 출력한다는 조건 맞추기
				System.out.println();
			}
		}
		
		
	}
}
