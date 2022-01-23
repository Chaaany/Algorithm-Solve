package boj;
import java.util.Arrays;
import java.util.Scanner;

public class boj_2309 {
	
	private static int[] persons = new int[9]; 
	private static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < persons.length; i++) {
			persons[i] = sc.nextInt();
			sum+= persons[i];
		}
		
		all : for(int i = 0; i < persons.length; i++) {
			for (int j = i+1; j < persons.length; j++) {
				if ((sum - persons[i] - persons[j]) == 100) {
					persons[i] = 0;
					persons[j] = 0;
					break all;
				}
			}
		}
		
		Arrays.sort(persons);
	
		for (int i = 2; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
		
		
	}
}
