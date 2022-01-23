package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2386 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = new String();
		tmp = br.readLine();
		while(tmp.charAt(0)!='#') {
			int cnt = 0;
			for (int i = 1; i < tmp.length(); i++) {
				if(tmp.charAt(0)==tmp.charAt(i) || tmp.charAt(0) == (char)(tmp.charAt(i)+32)) {
					cnt++;
				}
			}
			System.out.printf("%s %d\n", tmp.charAt(0), cnt);
			tmp = br.readLine();
		}



	}
}