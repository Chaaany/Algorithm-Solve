package prof_Honey_recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IM_Practice1 {

	static int T, N, cnt;
	static boolean arr[], tempArr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new boolean[N + 1]; // 0번째 인덱스 안씀
			tempArr = new boolean[N + 1]; // 0번째 인덱스 안씀
			stz = new StringTokenizer(br.readLine());
			cnt = 0;
			
			
			for (int i = 1; i <= N; i++) {
				if (Integer.parseInt(stz.nextToken()) == 1)
					arr[i] = true;
			}

			for (int i = 1; i <= N; i++) {
				if (arr[i] != tempArr[i]) { // 달라? 바꿔!
					boolean temp = arr[i];
					for (int j = i; j <= N; j += i) {
						tempArr[j] = !tempArr[j] ;
					}
					cnt++;
				}
			}
			sb.append("#"+t +" "+ cnt+"\n");
		}
		System.out.println(sb);
	}
}
