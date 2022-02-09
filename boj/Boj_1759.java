package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759 {
	
	static int L, C, start=0, cnt=0;
	static char[] arr;
	static char[] chars;
	static StringBuilder sb;
	static char[] c = {'a','e','i', 'o', 'u'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		L = Integer.parseInt(stz.nextToken());
		C = Integer.parseInt(stz.nextToken());
		chars = new char[L];
		sb = new StringBuilder();
		arr = br.readLine().replace(" ","").toCharArray();
		Arrays.sort(arr);
		nCr(0,0);
		System.out.println(sb);
		
	}
	public static void nCr(int cnt, int start) {
		if(cnt == L) {
			StringBuilder sbTemp = new StringBuilder();
			for (int i = 0; i < chars.length; i++) {
				sbTemp.append(chars[i]);
			}
			if(check(sbTemp.toString())) {
				sb.append(sbTemp.toString()).append("\n");
			}
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			chars[cnt] = arr[i];
			nCr(cnt+1, i+1);
		}
	}
	private static boolean check(String string) {
		int tempCnt = 0;
		for (int i = 0; i <5 ; i++) {
			if(string.contains((char)c[i]+"")) tempCnt++;
		}
		if(tempCnt >= 1 && string.length()-tempCnt >=2 ) {
			return true;
		}
		return false;
	}
}	
