import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class InputGenerator {
        
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            int H = (int)(Math.random()*6)+5;
            int N = (int)(Math.random()*4)+2;
            int M = (int)(Math.random()*4)+2;
            
            int Fh = (int)(Math.random()*H)+1;
            int Fn = (int)(Math.random()*N)+1;
            int Fm = (int)(Math.random()*M)+1;
            
            int S = (int)(Math.random()*6);
            int W = (int)(Math.random()*H);
            
            System.out.println(H + " " + N + " " + M + " " + Fh + " " + Fn + " " + Fm);
            System.out.println(S+" "+W);

            // 스프링 쿨러 위치
            int cnt=0;
            while(true) {
                if(cnt==S) break;
                
                int Sh = (int)(Math.random()*H)+1;
                int Sn = (int)(Math.random()*N)+1;
                int Sm = (int)(Math.random()*M)+1;
                
                // 화재 난 위치에 스프링 쿨러 올 수 없다.
                if(Fh==Sh && Fn==Sn && Fm==Sm) continue;
                cnt++;
                
                System.out.println(Sh+" "+Sn + " " + Sm);
            }
            
            // 창문 조합
            HashSet<Integer> hs = new HashSet<>();
            
            while(hs.size() < W) {
                int ww = (int)(Math.random()*H)+1;
                hs.add(ww);
            }
            for(int w : hs) {
                System.out.println(w);
            }
        }

    }
}