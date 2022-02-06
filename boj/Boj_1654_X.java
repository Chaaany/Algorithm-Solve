package boj;

import java.util.Scanner;

public class Boj_1654_X {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        long n = scan.nextLong();
        long arr[] = new long[k];
        long max = 0;

        for(int i = 0;i<k;i++){
            arr[i] = scan.nextLong();
            max = Math.max(max,arr[i]);
        }

        long left = 1;
        long right = max;

        while(left<=right){
            long mid = (right+left)/2;
            long sum = 0;
            for(int i = 0; i<k;i++){
                // 중간 값으로 배열값들을 나누면 개수가 나옴
                sum += arr[i]/mid;
            }
            if(sum >= n){ // sum이 더 많으면 자르는 길이를 늘릴 필요가 있음
                left = mid+1;
            }else{ // sum이 더 적으면  자르는 길이를 줄일 필요가 있음
                right = mid-1;
            }
        }
        System.out.println(right);
    }
}