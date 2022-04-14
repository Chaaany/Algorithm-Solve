package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_13305 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		2<= 도시의 개수(N) <= 100,000, 1 <= 도시의 거리 <= 1,000,000,000, 1 <= 리터당 가격 <= 1,000,000,000 
//		-> 최대 1,000,000,000,000,000,000 => long 선업 
//		일단 맨 처음 도시에서는 무조건 기름을 넣어야함 -> 얼만큼? -> 최소값을 지닌 도시까지의 거리 만큼
//		맨 처음의 도시가 가장 쌀 경우에는 그냥 거리 x 첫번째 도시 가격만큼 
//		아닐 경우 그 다음 싼 도시까지의 거리 x 첫번째도시 가격 + 마지막 도시의 거리까지 * 그다음 싼도시의 가격
// 		이번 보다 더 싼 값으로 팔면 그때그때 넣기!
//		PriorityQueue<long[]> price = new PriorityQueue<>(new Comparator<long[]>() {
//			@Override
//			public int compare(long[] o1, long[] o2) {
//				// 기름값이 같다면 거리가 가까운 순으로
//				if (o1[0] == o2[0]) {
//					if (o1[1] < o2[1]) {
//						return -1;
//					} else if (o1[1] == o2[1]) {
//						return 0;
//					} else {
//						return 1;
//					}
//				} else {
//					if (o1[0] < o2[0]) {
//						return -1;
//					} else if (o1[0] == o2[0]) {
//						return 0;
//					} else {
//						return 1;
//					}
//				}
//			}
//		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int N = Integer.parseInt(br.readLine());
		long answerCost = 0L;
		long distance[] = new long[N - 1];
		long fuelPrice[] = new long[N-1];

		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Long.parseLong(stz.nextToken());
		}
		
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < fuelPrice.length; i++) {
			if (i == 0) {
				fuelPrice[i] = Long.parseLong(stz.nextToken());
			} else {
				fuelPrice[i] = Long.parseLong(stz.nextToken());
				if (fuelPrice[i - 1] <= fuelPrice[i]) { // 더 싸거나 같다
					fuelPrice[i] = fuelPrice[i - 1];
				}
			}
			
			answerCost += fuelPrice[i] * distance[i];
		}
		System.out.println(answerCost);

	}
}
