package lecture;

public class Selection_sort {
	public static void main(String[] args) {
		// N * (N+1) /2 = O(N*N) / N+1C2
		// 가장 작은 것을 선택해서 제일 앞으로 보내면 어떨까
		int min, index = 0, temp;
		int[] array = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
		for (int i = 0; i < array.length; i++) {
			min = Integer.MAX_VALUE;
			for (int j = i; j < array.length; j++) {
				if (min > array[j]) {
					min = array[j];
					index = j;
				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
