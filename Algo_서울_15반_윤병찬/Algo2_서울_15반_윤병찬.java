import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_15반_윤병찬 {
	static boolean canChk[];
	static int chuWeight[], bidWeight[], total[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 추의 개수<= 30 // 자연수
		// 가벼운 것부터 순서대로 500g이하
		// 확인할 구슬의 개수는 7 이하
		// 구슬의 무게는 40,000보다 작거나 같음
		// 구슬과 추 몇 개를 선택 했을 때 같은게 있니?와 동치

		canChk = new boolean[20000]; // 확인 가능한 구슬의 무게 배열 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력용 BufferedReader
		StringTokenizer stz; // 입력용 StringTokenizer
		StringBuilder sb = new StringBuilder(); // 정답 출력용 StringBuilder
		int N = Integer.parseInt(br.readLine()); // 추의 갯수 입력
		chuWeight = new int[N]; // 추의 무게 할당할 배열 선언
		stz = new StringTokenizer(br.readLine()); // 추의 무게 입력받을 stringTokenizer
		for (int i = 0; i < chuWeight.length; i++) { // 추 무게 할당
			chuWeight[i] = Integer.parseInt(stz.nextToken());
		}

		int M = Integer.parseInt(br.readLine()); // 구슬의 갯수 입력
		bidWeight = new int[M]; // 구슬 무게 할당할 배열 선언
		stz = new StringTokenizer(br.readLine()); // 구슬의 무게 입력받을 stringTokenizer
		for (int i = 0; i < bidWeight.length; i++) { // 구슬 무게 할당
			bidWeight[i] = Integer.parseInt(stz.nextToken()); 
		}

		subSet(0, 0, 0); // 측정가능한 구슬 무게 값 구하기

		for (int i = 0; i < bidWeight.length; i++) { // 측정가능한 구슬 무게 여부 판단 후 답 출력
			sb.append(canChk[bidWeight[i]] ? "Y " : "N ");
		}
		sb.setLength(sb.length() - 1); // 정답 출력전 공백 제거
		System.out.println(sb); // 정답출력
	}

	private static void subSet(int cnt, int selectedChuTotal, int unselectedChuTotal) {
		canChk[Math.abs(unselectedChuTotal - selectedChuTotal)] = true; // 측정 가능한 구슬 무게로 처리
		if (cnt < chuWeight.length) { // cnt번 째 추의 부분집합 구하기
			subSet(cnt + 1, selectedChuTotal + chuWeight[cnt], unselectedChuTotal);
			subSet(cnt + 1, selectedChuTotal, unselectedChuTotal + chuWeight[cnt]);
		}
	}
}
