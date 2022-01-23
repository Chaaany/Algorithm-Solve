package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_23351 {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] catLeaf = new int[N];
		int aliveDayCounter = 0;
		for(int i = 0; i < N; i++) {
			catLeaf[i] = K;
		}

		while( catLeaf[0] > 0) {
			for(int i = 0; i < A; i++) {
				catLeaf[i] += B;
			}

			for(int j = 0; j < N; j++) {
				catLeaf[j] -= 1;
			}
			aliveDayCounter++;
			Arrays.sort(catLeaf);
		}
		System.out.println(aliveDayCounter);
	}
}
