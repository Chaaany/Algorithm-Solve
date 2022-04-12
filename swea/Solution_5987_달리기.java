package swea;

public class Solution_5987_달리기 {
	public static void main(String[] args) {
		long temp = 1;
		for (int i = 1;  i <= 16; i++) {
			temp*= i;
			System.out.println(i +" : "+ temp);
		}
		
	}
}
