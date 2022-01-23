package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		int sum = 0;
		for (String string : data) {
			sum+= Integer.parseInt(string)*Integer.parseInt(string);
		}
		System.out.println(sum%10);
		
	}
}
