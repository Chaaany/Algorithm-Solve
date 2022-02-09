package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_D3_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 1;
		while (t <= 10) {
			int keyCnt = Integer.parseInt(br.readLine()); // 입력 1
			StringBuilder sb = new StringBuilder();
			String[] key;
			List<String> list = new LinkedList<>();
			key = br.readLine().split(" "); // 입력 2
			for (int i = 0; i < keyCnt; i++) {
				list.add(key[i]);
			}
			int cnt = 0;
			cnt = Integer.parseInt(br.readLine()); // 입력 3
			while (cnt-- > 0) //
			{
				String[] arr = br.readLine().split(" "); // 입력 4
				int arrcnt = 0;
				int a = 1;
				while (cnt-- >= 0) { // 입력 4갯수만큼 순회
					if (arr[arrcnt++].equals("I")) {
						int sortIndex = Integer.parseInt(arr[arrcnt++]);
						int arrsize = Integer.parseInt(arr[arrcnt++]);
						for (int i = 0; i < arrsize; i++) {
							list.add(sortIndex++, arr[arrcnt++]);
						}
					} 
				}
				for (int i = 0; i < 10; i++) {
					sb.append(list.get(i)+" ");
				}
				System.out.println("#"+ t +" " + sb.toString().trim());
			}
			t++;
		}
		// 처리

		// 출력

	}
}