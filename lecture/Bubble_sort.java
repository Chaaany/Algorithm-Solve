package lecture;

public class Bubble_sort {
	public static void main(String[] args) {
		// 옆에 있는 값과 비교해서 더 작은 값을 앞으로 보내면 어떨까? -> 가장 비효율적인 알고리즘
		// 가장 큰 값이 맨 뒤로 이동하게 됨.
		// 반복할 때마다 집합의 크기가 하나씩 줄어듦. 선택정렬과 동일한 시간 복잡도 O(N*N) but 선택정렬보다 소요시간이 더 걸림
		// 선택 정렬은 가장 작은 수 하나 기억해서 할당 한 번이지만, 버블 정렬은 옆에 있는 수와 비교해서 계속 할당해주기 때문
		int temp;
		int[] array = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
