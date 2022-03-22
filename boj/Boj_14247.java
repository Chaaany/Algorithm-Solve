package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_14247 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long total = 0; 
		// 나무 100,000개에  등차가 10,000이고 첫항이 전부 100,000 일 경우   99999*100000/2*10000 + 100000  = 49,999,500,100,000 => long으로 선언해야함 
		// long = +-9,223,372,036,854,775,807, int +- = 2,147,483,647
		
		// 배열, 연결리스트로 구현한다면 삭제 O(1), 삽입(n)
		// 우선순위 큐의 경우 삭제, 삽입 O(log2n); n= 100000기준 32
		// Arrays.sort의 경우 dualPivotQuicksort : 평균 O(nlogn) 최악:O(n^2) 100000 기준 평균 1600000
		// Collections.sort의 경우 Timsort :  평균 O(nlogn) 최악:O(n^2) n = 100000 기준 평균 1600000
		// 한 번의 정렬을 하여 사용하여야 하며 데이터가 지속적으로 필요하지 않으므로 우선순위 큐를 사용한다.
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		// 각 나무의 상수 부분은 미리 더해줘도 된다. 결국 공차의 오름차순 대로 나무를 자르게 될 것이다.
		for (int i = 0; i < n; i++) {
			total += Integer.parseInt(stz.nextToken());
		}
		stz = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(stz.nextToken()));
		}
		
		// 우선순위 큐의 경우 객체 생성시 Collections.reverseOrder()을 파라미터로 넘겨주면 내림차순으로 정렬된다.
		for (int i = 0; i < n; i++) {
			total += i*pq.poll(); // 첫째날부터 자른다고 한다면 n은 0부터 시작한다.
		}
		
		System.out.println(total);
		
		
		// 배열 version
		
		int tree[] = new int[n];
		StringTokenizer stz2 = new StringTokenizer(br.readLine());
		
		// 각 나무의 상수 부분은 미리 더해줘도 된다. 결국 공차의 오름차순 대로 나무를 자르게 될 것이다.
		for (int i = 0; i < n; i++) {
			total += Integer.parseInt(stz2.nextToken());
		}
		stz2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(stz2.nextToken());
		}
		Arrays.sort(tree);
		// 우선순위 큐의 경우 객체 생성시 Collections.reverseOrder()을 파라미터로 넘겨주면 내림차순으로 정렬된다.
		for (int i = 0; i < n; i++) {
			total += i*tree[i]; // 첫째날부터 자른다고 한다면 n은 0부터 시작한다.
		}
		
		System.out.println(total);
		
		
		
	}
}
