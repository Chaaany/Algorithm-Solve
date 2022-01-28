package lecture;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

public class Quick_sort {
	static int[] data = { 3, 7, 8, 1, 5, 9, 6, 10, 2, 4 };
	static int number = 10;
	
	

	public static void main(String[] args) {
		quickSort(data, 0, number-1);
		for (int i = 0; i < number; i++) {
			System.out.printf("%d", data[i]);
		}
	}
	
	public static void quickSort(int[] data, int start, int end) {
		if (start >= end) { // 원소가 자기 자신이거나 엇갈릴 경우
			return;
		}

		int key = start; // 키는 첫 번째 원소
		int i = start + 1;
		int j = end;
		int temp;

		while (i <= j) { // 같거나 엇갈릴 때까지 반복
 			while (data[i] <= data[key]) {// 키의 값과 같아질 때 까지 오른쪽으로 이동
				i++;
			}
			while (j > start && data[j] >= data[key]) {// 
				j--;
			}
			if (i > j) { // 현재 엇갈린 상태면 키 값과 교체
				temp = data[j];
				data[j] = data[key];
				data[key] = temp;
			} else {
				temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		quickSort(data, start, j - 1);
		quickSort(data, j + 1, end);

	}
}
