package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> hm = new HashMap<>();
		StringTokenizer stz;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] temp = new int[N];
		int cnt = 0;

		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
			temp[i] = arr[i];
		}
		Arrays.sort(temp);
		
		for (int i = 0; i < temp.length; i++) {
			if(!hm.containsKey(temp[i])) hm.put(temp[i], cnt++);
		}
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(hm.get(arr[i])+" ");
		}
		System.out.println(sb);

	}

}
