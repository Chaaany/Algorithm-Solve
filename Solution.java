import java.util.Arrays;
import java.util.Scanner;

class Solution {
	static int T, N, min, total, enter[][], enterSeq[][] = { { 1, 0, 2 }, { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 0 },
			{ 2, 1, 0 }, { 2, 0, 1 }, { -1, -1, -1 } };

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			enter = new int[3][2]; // 출입구 갯수 3개
			for (int i = 0; i < 3; i++) {
				enter[i][0] = sc.nextInt(); // 게이트 넘버
				enter[i][1] = sc.nextInt(); // 입장사람 수
			}
			for (int i = 0; i < 6; i++) {
				total = 0;
				int[] arr = new int[N + 1];
				start(enter[enterSeq[i][0]][1], enter[enterSeq[i][0]][0], 1, i, arr);
			}
			System.out.println("#" + t + " " + min);
		}

		sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}

	private static void start(int targetPerson, int gateNum, int key, int forKey, int[] preArr) {
		if(key == 4) {
			min = Math.min(total, min);
			total = 0;
			return;
		}
		boolean check = false;
		int[] curArr = Arrays.copyOf(preArr, preArr.length);
		
		int left = gateNum - 1;
		int right = gateNum + 1;
		int spareP = targetPerson;
		while (spareP != 0) {
			if (curArr[gateNum] == 0) { // 게이트 바로 앞의 자리가 있다?
				curArr[gateNum] = 1;
				total++;
				spareP--;
			} else {
				if (check(left) && check(right)) {
					if (curArr[left] == 0 && curArr[right] == 0) { // 양쪽 모두 자리 있음
						if (spareP != 1) { // 남은 사람이 1명이 아닌 경우
							curArr[left] = 1;
							total += Math.abs(gateNum - left) + 1;
							curArr[right] = 1;
							total += Math.abs(gateNum - right) + 1;
							spareP -= 2;
							left--;
							right++;
							continue;
						} else { // 남은 사람이 1명일 경우
							curArr[left] = 1;
							total += Math.abs(gateNum - left) + 1;
							start(enter[enterSeq[forKey][key]][1], enter[enterSeq[forKey][key]][0], key+1,forKey, curArr);
							total -= Math.abs(gateNum - left) + 1;
							curArr[left] = 0;
							
							check = true;
							
							curArr[right] = 1;
							total += Math.abs(gateNum - right) + 1;
							start(enter[enterSeq[forKey][key]][1], enter[enterSeq[forKey][key]][0], key+1,forKey, curArr);
							curArr[right] = 0;
							total -= Math.abs(gateNum - right) + 1;
							check = true;
							break;
						}
					} else if (curArr[left] != 0 && curArr[right] == 0) { // 오른쪽만 자리 있음
						curArr[right] = 1;
						total += Math.abs(gateNum - right) + 1;
						spareP--;
						left--;
						right++;
						continue;
					} else if (curArr[left] == 0 && curArr[right] != 0) { // 왼쪽만 자리 있음
						curArr[left] = 1;
						total += Math.abs(gateNum - left) + 1;
						spareP--;
						left--;
						right++;
						continue;
					}else {
						left--;
						right++;
					}

				} else if (!check(left) && check(right)) {
					if(curArr[right]==0) {
						curArr[right] = 1;
						total += Math.abs(gateNum - right) + 1;
						spareP--;
						left--;
						right++;
						continue;
					}else {
						left--;
						right++;
					}
				} else if (check(left) && !check(right)) {
					if(curArr[left]==0) {
						curArr[left] = 1;
						total += Math.abs(gateNum - left) + 1;
						spareP--;
						left--;
						right++;
						continue;
					}else {
						left--;
						right++;
					}
				}
			}
		}
		
		if(!check) {
			if(key == 3) {
				start(0, 0, key+1,0, curArr);
			}else {
				start(enter[enterSeq[forKey][key]][1], enter[enterSeq[forKey][key]][0], key+1,forKey, curArr);
			}
		}
		
	}

	private static boolean check(int n) {
		return 1 <= n && n <= N;
	}
}
