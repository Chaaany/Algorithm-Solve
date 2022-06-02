package 계절학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 소미님 {
    
    static class Room implements Comparable<Room> {
        int h;
        int r;
        int c;
        int t;
        public Room(int h, int r, int c, int t) {
            super();
            this.h = h;
            this.r = r;
            this.c = c;
            this.t = t;
        }
        @Override
        public int compareTo(Room o) {
            
        	return this.t - o.t;
        }
        
    }

    // 가로, 세로, 높이, 창문 수, 스프링쿨러 수
    static int N, M, H, W, S;
    // 건물 맵
    static int[][][] map;
    // 불이 난 곳인지 check
    static boolean[][][] fired;
    // 창문이 존재하는 층
    static boolean[] window;
    // 불이 모두 퍼지는 시간
    static int time;
    // 상 하 좌 우
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    // 위아래
    static int[] dh = { -1, 1 };
    //공간 수
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int t = 0; t < 50; t++) {
            time = 0; count = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        fired = new boolean[H][N][M];
        window = new boolean[H];
        count = H * N * M;

        // 불이 난 좌표 -> 1
        int fH = Integer.parseInt(st.nextToken()) - 1;
        int fN = Integer.parseInt(st.nextToken()) - 1;
        int fM = Integer.parseInt(st.nextToken()) - 1;

        map[fH][fN][fM] = 1;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        // 스프링쿨러 좌표 -> 2
        for (int s = 0; s < S; s++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[h][r][c] = 2;
        }

        // 창문이 있는 층 -> true
        for (int w = 0; w < W; w++) {
            int f = Integer.parseInt(br.readLine()) - 1;
            window[f] = true;
        }

        // 불이 퍼진다
        spread(fH, fN, fM);

        System.out.println("#"+(t+1)+" "+time);
//        System.out.println(time);
        }

    }

    static PriorityQueue<Room> queue;

    private static void spread(int fH, int fN, int fM) {

        queue = new PriorityQueue<>();
        queue.offer(new Room(fH, fN, fM, 0));
        fired[fH][fN][fM] = true;

        while (!queue.isEmpty()) {
            Room cur = queue.poll();
            int ch = cur.h;
            int cr = cur.r;
            int cc = cur.c;
            int t = cur.t;
            
            //시간이 지났으면
            if (t > time) {
                // check한 곳 확인
                int cnt = fire(t);
                
                /*
                // 검증 코드
                System.out.println(time + " " + t);
                for (int h = H - 1; h >= 0; h--) {
                    for (int n = 0; n < N; n++) {
                        for (int m = 0; m < M; m++) {
                            System.out.print(map[h][n][m]);
                        }
                        System.out.println();
                    }
                    System.out.println(h + 1 + "층");
                }
                */
                time = t;
                //모두 불탔으면 종료
                if(cnt == count) return;
                
            }
            
            

            // 위아래 check
            for (int d = 0; d < 2; d++) {
                int nh = ch + dh[d];
                if (check(nh, cr, cc) && !fired[nh][cr][cc]) {
                    // 스프링쿨러가 있으면 check만 한다
                    if (map[nh][cr][cc] == 2) {
                        fired[nh][cr][cc] = true;
                        queue.offer(new Room( nh, cr, cc, t + 2));
                    }
                    // 아무것도 없으면 check하고 큐에 넣는다
                    else if (map[nh][cr][cc] == 0 ) {
                        fired[nh][cr][cc] = true;
                        queue.offer(new Room ( nh, cr, cc, t+1));
                    }
                }
            }

            // 상하좌우 check
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (check(ch, nr, nc) && !fired[ch][nr][nc]) {
                    // 스프링쿨러가 있으면 check만 한다
                    if (map[ch][nr][nc] == 2) {
                        fired[ch][nr][nc] = true;
                        queue.offer(new Room( ch, nr, nc, t + 2 ));
                    }
                    // 아무것도 없으면 check하고 큐에 넣는다
                    else if (map[ch][nr][nc] == 0 ) {
                        fired[ch][nr][nc] = true;
                        queue.offer(new Room( ch, nr, nc, t+1 ));
                    }
                }

                // 창문이 있는 층이면 한칸씩 더 퍼진다
                if (window[ch]) {
                    nr += dr[d];
                    nc += dc[d];
                    if (check(ch, nr, nc) && !fired[ch][nr][nc]) {
                        if (map[ch][nr][nc] == 2) {
                            fired[ch][nr][nc] = true;
                            queue.offer(new Room( ch, nr, nc, t + 2 ));
                        } else if (map[ch][nr][nc] == 0 ) {
                            fired[ch][nr][nc] = true;
                            queue.offer(new Room( ch, nr, nc, t+1 ));
                        }
                    }
                }
            }

        }
    }

    // 불이 나는 위치 확인
    private static int fire(int t) {
        int cnt = 0;
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    // 불이 나는 위치
                    if (fired[h][r][c]) {
                        // 아무것도 없으면 불이 난다
                        if (map[h][r][c] == 0 ) {
                            map[h][r][c] = 1;
                        }
                        // 스프링쿨러가 있으면 다음번에 불이 날 곳 -> 3
                        else if (map[h][r][c] == 2) {
                            map[h][r][c] = 3;
                            // queue.offer(new int[] {h,r,c,t});
                        } else if(map[h][r][c] == 3) {
                            map[h][r][c] = 1;
                        }
                        
                    }
                    if(map[h][r][c]==1) cnt++;
                }
            }
        }
        return cnt;
    }

    // 배열 범위 확인
    private static boolean check(int h, int r, int c) {
        return h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M;
    }

}