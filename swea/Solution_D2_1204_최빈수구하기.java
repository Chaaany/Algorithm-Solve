package swea;
import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {
	public static void main(String[] args) {
		int T = 0;
		int N = 0;
		int[] nums;
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			nums=new int[100+1];
			for (int i = 0; i < 1000; i++) {
				int temp = sc.nextInt();
				nums[temp]++;
			}
			int max = -1;
			int index = -1;
			for (int i = 0; i < nums.length; i++)
				if(max<=nums[i]) {
//					max = Math.max(max, nums[i]); // 크다만 있고 같을 땐 안들어감 그래서 만들어야함
					max=nums[i];
					index=i;
				}
			System.out.println("#" + t + " "+ index);
		}
	}
}
