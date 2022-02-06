package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Solution_D3_1873_상호의배틀필드 {
    static int T;
    static int H, W;
    static int count;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static char[][] map;
    static char[] a = {'^','v','<','>'};
    static int sr; // 시작 위치 r
    static int sc; // 시작 위치 c
    static int sd; // 시작 방향
 
    static int[] tankpoint;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scann = new Scanner(System.in);
        T = scann.nextInt();
        for (int t = 0; t < T; t++) {
            H = scann.nextInt();
            W = scann.nextInt();
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                char[] cs = scann.next().toCharArray();
                for (int j = 0; j < W; j++) {
                    map[i][j] = cs[j];
                    if (map[i][j] == '^') {
                        sr = i;
                        sc = j;
                        sd = 0;
                    } else if (map[i][j] == 'v') {
                        sr = i;
                        sc = j;
                        sd = 1;
 
                    } else if (map[i][j] == '<') {
                        sr = i;
                        sc = j;
                        sd = 2;
 
                    } else if (map[i][j] == '>') {
                        sr = i;
                        sc = j;
                        sd = 3;
 
                    }
                }
            }
            int N = scann.nextInt();
            String S = scann.next();
 
            for (int i = 0; i < N; i++) {
                go(map, S.charAt(i));
            }
            map[sr][sc] = a[sd];
            System.out.print("#" + (t+1) + " ");
            print(map);
        }
    }
 
    private static void print(char[][] map2) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
 
    private static void go(char[][] map, char btn) {
        switch (btn) {
        case 'U':
            moveUp(sr, sc);
            break;
        case 'D':
            moveDown(sr, sc);
            break;
        case 'L':
            moveLeft(sr, sc);
            break;
        case 'R':
            moveRight(sr, sc);
            break;
        case 'S':
            shoot(sr, sc);
            break;
 
        }
    }
 
    private static boolean tankCanMove(int sr2, int sc2) {
         
        return 0 <= sr2 && sr2 < H && 0 <= sc2 && sc2 < W && map[sr2][sc2] == '.';
    }
 
    private static void moveUp(int sr2, int sc2) {
        int tmpsr = sr2 + dr[0];
        int tmpsc = sc2 + dc[0];
        if (tankCanMove(tmpsr, tmpsc)) {
            map[sr][sc] = '.';
            sr = tmpsr;
            sc = tmpsc;
            sd = 0;
        } else {
            sd = 0;
        }
    }
 
    private static void moveDown(int sr2, int sc2) {
        int tmpsr = sr2 + dr[1];
        int tmpsc = sc2 + dc[1];
        if (tankCanMove(tmpsr, tmpsc)) {
            map[sr][sc] = '.';
            sr = tmpsr;
            sc = tmpsc;
            sd = 1;
             
        }else {
            sd = 1;
        }
    }
 
    private static void moveLeft(int sr2, int sc2) {
        int tmpsr = sr2 + dr[2];
        int tmpsc = sc2 + dc[2];
        if (tankCanMove(tmpsr, tmpsc)) {
            map[sr][sc] = '.';
            sr = tmpsr;
            sc = tmpsc;
            sd = 2;
        }else {
            sd =2;
        }
    }
 
    private static void moveRight(int sr2, int sc2) {
        int tmpsr = sr2 + dr[3];
        int tmpsc = sc2 + dc[3];
        if (tankCanMove(tmpsr, tmpsc)) {
            map[sr][sc] = '.';
            sr = tmpsr;
            sc = tmpsc;
            sd = 3;
        }else {
            sd = 3;
        }
    }
 
    private static void shoot(int sr2, int sc2) {
        int tmpsr = sr2 + dr[sd];
        int tmpsc = sc2 + dc[sd];
        if (CanShoot(tmpsr, tmpsc)) {
            if (map[tmpsr][tmpsc] == '.' || map[tmpsr][tmpsc] == '-') {
                shoot(tmpsr, tmpsc);
            } else if (map[tmpsr][tmpsc] == '*') {
                map[tmpsr][tmpsc] = '.';
                return;
            } else {
                return;
            }
        }else {
            return;
        }
    }
 
    private static boolean CanShoot(int sr2, int sc2) {
        return 0 <= sr2 && sr2 < H && 0 <= sc2 && sc2 < W && map[sr2][sc2] != '#';
    }
}