package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_D3_1225_암호생성기 {
    public static void main(String[] args) throws IOException {
         
//      입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while(t <= 1) {
        	StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
            t = Integer.parseInt(stz.nextToken().trim());
            stz = new StringTokenizer(br.readLine(), " ");
             
            while(stz.hasMoreTokens()) {
                q.offer(Integer.parseInt(stz.nextToken()));
            }
             
            //      싸이클
            int m = 0;
            while(true) {
                m = m % 5 + 1;
                int temp = q.peek()-m;
                if(temp <= 0) {
                    q.poll();
                    q.offer(0);
                    break;
                } else {
                    q.offer(q.poll()-m);
                }
            }
//          
            sb.append("#"+(t++));
            for (int i = 0; i < 8; i++) {
                sb.append(" "+q.poll());
            }
            sb.append("\n");
        }
         
//      출력
        System.out.println(sb);
    }
}