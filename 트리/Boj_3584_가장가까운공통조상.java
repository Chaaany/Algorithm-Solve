package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_3584_가장가까운공통조상 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 부모 자식 관계를 알려준 경우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());
			int parent[] = new int[N + 1];

			for (int j = 0; j < parent.length; j++) {
				parent[j] = 0;
			}

			for (int j = 0; j < N - 1; j++) {
				stz = new StringTokenizer(br.readLine());

				int A = Integer.parseInt(stz.nextToken());
				int B = Integer.parseInt(stz.nextToken());

				parent[B] = A;
			}

			stz = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(stz.nextToken());
			int y = Integer.parseInt(stz.nextToken());

			List<Integer> X = new ArrayList<>();
			List<Integer> Y = new ArrayList<>();

			X.add(x);
			Y.add(y);

			while (parent[x] != 0) {
				X.add(parent[x]);
				x = parent[x];
			}

			while (parent[y] != 0) {
				Y.add(parent[y]);
				y = parent[y];
			}
//			boolean v[] = new boolean[N + 1];
//			int answer = 0;
//			for (int j = 0; j < X.size(); j++) {
//				v[X.get(j)] = true;
//			}
//
//			for (int j = 0; j < Y.size(); j++) {
//				if (v[Y.get(j)]) {
//					answer = Y.get(j);
//					break;
//				}
//			}

			int xSize = X.size() - 1;
			int ySize = Y.size() - 1;

			while (xSize >= 0 && ySize >= 0 && X.get(xSize).equals(Y.get(ySize))) {
				xSize--;
				ySize--;
			}

			System.out.println(X.get(xSize+1));
		}

	}
}