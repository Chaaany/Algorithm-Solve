package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class boj_15649 {
    public static int N;
    public static int M;
    public static int arr[] = new int[110];
    public static void recur(int cur,int start){
        if(cur == N){
            for(int i=0; i<N; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
            return ;
        }
        for(int i=start;i<=M;i++){
            arr[cur] = i;
            recur(cur+1, i+1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        recur(0, 1);
        
    }
}