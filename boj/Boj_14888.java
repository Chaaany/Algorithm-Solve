package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj_14888 {
	static int N, min, max, arr[], op[], tempOp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		arr = new int[N];
		tempOp = new int[N-1];
		op = new int[N-1];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		stz = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		stz = new StringTokenizer(br.readLine());
		
		int temp = 0;
		int index = 0;
		
		for (int i = 0; i < 4; i++) {
			temp = Integer.parseInt(stz.nextToken());
			for (int j = 0; j < temp; j++) {
				if(i == 0) {
				op[index++] = '+';
				} else if(i == 1) {
					op[index++] = '-';
				} else if(i == 2) {
					op[index++] = '*';
				} else if(i == 3) {
					op[index++] = '/';
				}
			}
		}
		perm(0, new boolean[N-1]);
		
		System.out.println(max+"\n"+min);
	}
	private static void perm(int cnt, boolean[] visited) {
		if(cnt == N-1) {
			min = Math.min(min, operation());
			max = Math.max(max, operation());
			return;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			tempOp[cnt]	= op[i];
			perm(cnt+1, visited);
			visited[i] = false;
		}
	}
	
	private static int operation() {
		int total = arr[0];
		for (int i = 0; i < tempOp.length; i++) {
			switch (tempOp[i]) {
			case '+':
				total += arr[i+1];
				break;
			case '-':
				total -= arr[i+1];
				break;
			case '*':
				total *= arr[i+1];
				break;
			case '/':
				if(total >0) {
				total /= arr[i+1];
				} else {
					total =  total * -1 / arr[i+1] * -1; 
				}
				break;
			}
		}
		return total;
	}
}
