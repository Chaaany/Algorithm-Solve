package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj_5430 {
	public static void main(String[] args) throws IOException {
		// 함수 R은 배열에 있는 수의 순서를 뒤집는 함수
		// D는 첫 번째 수를 버리는 함수 - 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
		// 함수는 조합해서 한 번에 사용할 수 있다.
		// 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다."RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수
		// T <= 100, 1 <= p(수행할 함수) <=100,000
		// 0 <= 배열에 들어있는 수의 개수 <= 100,000
		// 1 <= xi(정수의 크기) <100
		// (p + n)*T <= 700,000
		// RRD = D, RDR = popright 후 뒤집기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			String keys[] = br.readLine().split(""); // 수행할 함수 배열 넣기
			int N = Integer.parseInt(br.readLine()); // for문 순회용 변수
			String temp = br.readLine().trim(); // 덱에 넣을 값 임시저장용 String
			temp = temp.substring(1, temp.length() - 1); // [,] 제거
			String values[] = temp.split(","); // String 배열로 원소 할당

			Deque<String> dq = new ArrayDeque<>();
			for (int j = 0; j < N; j++) { // 덱에 넣기
				dq.addLast(values[j]);
			}
			// D의 갯수 구하기 => error처리
			int DCnt = 0;
			boolean cursor = false; // false = 맨 앞, true = 맨 뒤
			for (int j = 0; j < keys.length; j++) {
				if (keys[j].equals("D"))
					DCnt++;
			}
			if (DCnt > dq.size()) { // D의 갯수가 dq사이즈 보다 크면 error남
				sb.append("error\n");
			} else if(DCnt == dq.size()) {
				sb.append("[]\n");
			}else {
			
				for (int j = 0; j < keys.length; j++) {
					if (keys[j].equals("R")) { // 배열 뒤집기
						cursor = !cursor;
					} else { // 첫 번째 수 버리기
						if (cursor) { // 커서가 뒷쪽을 가리킬 경우
							dq.pollLast();
						} else { // 앞쪽을 가리킬경우
							dq.pollFirst();
						}
					}
				}
				if (cursor) { // 커서가 뒷쪽을 가리킬 경우
					sb.append("[");
					while (!dq.isEmpty()) {
						sb.append(dq.pollLast()).append(",");
					}
					sb.setLength(sb.length()-1); 
					sb.append("]\n");
				} else { // 커서가 뒷쪽을 가리킬 경우
					sb.append("[");
					while (!dq.isEmpty()) {
						sb.append(dq.pollFirst()).append(",");
					}
					sb.setLength(sb.length()-1); 
					sb.append("]\n");
				}
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
