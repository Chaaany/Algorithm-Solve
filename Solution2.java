import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution2 {
	static int T, N, map[][], tempMap[][], countMap[][], monster, nums[], min,
			delta[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상하좌우
	static boolean mapVisited[][];
	static HashMap<Integer, int[]> hm1;
	static HashMap<int[], Integer> hm2;
	static Queue<int[]> q;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			hm1 = new HashMap<>();
			hm2 = new HashMap<>();
			q = new LinkedList<>();

			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			monster = 0;
			for (int i = 1; i <= N; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(stz.nextToken());
					if (map[i][j] != 0) {
						hm1.put(map[i][j], new int[] { i, j });
						hm2.put(new int[] { i, j }, map[i][j]);
						monster = Math.max(monster, map[i][j]); // 몬스터 수
					}
				}
			}
			nums = new int[monster * 2];
			selectSeq(0, new boolean[monster * 2 + 1]);
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
		

	}

	private static void selectSeq(int cnt, boolean[] visited) {
		if (cnt != 0 && nums[cnt - 1] > monster && !visited[nums[cnt - 1] - monster])
			return; // 몬스터를 잡지 않고 고객에게 간 경우

		if (cnt == monster * 2) {
//			start();
			calc();
			return;
		}

		for (int i = 1; i <= monster * 2; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			nums[cnt] = i;
			selectSeq(cnt + 1, visited);
			visited[i] = false;
		}
	}

	private static void calc() {
		int seq[] = Arrays.copyOf(nums, nums.length);
		int total = 0;
		for (int i = 0; i < seq.length; i++) {
			if (seq[i] > monster) {
				seq[i] = (seq[i] - monster) * -1; // 고객 변환
			}
		}
		for (int i = 0; i < seq.length; i++) {
			if (i == 0) {
				total += Math.abs(hm1.get(seq[i])[0] - 1) + Math.abs(hm1.get(seq[i])[1] - 1);
			} else {
				total += Math.abs(hm1.get(seq[i-1])[0] - hm1.get(seq[i])[0]) + Math.abs(hm1.get(seq[i-1])[1] - hm1.get(seq[i])[1]);
			}
		}
		
		min = Math.min(total, min);
	}

	private static void start() {
		int seq[] = Arrays.copyOf(nums, nums.length);
		for (int i = 0; i < seq.length; i++) {
			if (seq[i] > monster) {
				seq[i] = (seq[i] - monster) * -1; // 고객 변환
			}
		}
		tempMap = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) { // 맵 복사
			tempMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		int total = 0;

		for (int i = 0; i < seq.length; i++) { // 해당 타겟으로 bfs
			if (i == 0) {
				q.clear(); // 큐 초기화
				q.add(new int[] { 1, 1 }); // 시작점
				total += bfs(seq[i]);
			} else {
				q.clear(); // 큐초기화
				q.add(hm1.get(seq[i - 1])); // 이전에 있던곳이 시작점
				total += bfs(seq[i]);
			}
		}
		min = Math.min(total, min);
	}

	private static int bfs(int target) {
		int temp[], r, c, nr, nc;
		int targetR = hm1.get(target)[0];
		int targetC = hm1.get(target)[1];

		mapVisited = new boolean[N + 1][N + 1];
		countMap = new int[N + 1][N + 1];
		while (!q.isEmpty()) {
			temp = q.poll();
			r = temp[0];
			c = temp[1];
			mapVisited[r][c] = true; // 방문처리
			for (int i = 0; i < 4; i++) {
				nr = r + delta[i][0];
				nc = c + delta[i][1];
				// 경계안, 미방문이 아닐 경우 continue
				if (!(1 <= nr && nr <= N && 1 <= nc && nc <= N && !mapVisited[nr][nc]))
					continue;

				// target이면 넣어
				if (tempMap[nr][nc] == target) {
					countMap[nr][nc] = countMap[r][c] + 1;
					mapVisited[nr][nc] = true;
					tempMap[nr][nc] = 0;
					return countMap[nr][nc];
				}
				// 빈칸 아니면 넘어가
				if (tempMap[nr][nc] != 0)
					continue;

				// 빈칸일 경우
				mapVisited[nr][nc] = true; // 방문처리
				countMap[nr][nc] = countMap[r][c] + 1;
				q.add(new int[] { nr, nc }); // 큐에 넣기
			}
		}
		return countMap[targetR][targetC];
	}

}