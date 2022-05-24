package 우테캠;

import java.util.*;
import java.io.*;

class Solution2 {
    static int arr[][], tempArr[][], delta[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}, boardLen, tempAnswer, max;
    public static int solution(String[] board) {
        // dfs 또는 bfs이용
        int answer = 0;
        boardLen = board.length;
        arr = new int[boardLen+2][boardLen+2]; // 패딩
        tempArr = new int[boardLen+2][boardLen+2];// 임시

        for(int i = 1; i <= board.length; i++){
            char[] temp = board[i-1].toCharArray();
            for(int j = 1; j <= board.length; j++){
                arr[i][j] = temp[j-1] - 'A' + 1;
                tempArr[i][j] = temp[j-1] - 'A' + 1;   
            }
        }

        max = 0;
        for(int i = 1; i <= boardLen; i++){
            //행 이동
            tempAnswer = 0;
            for(int j = 1; j <= board.length; j++){
                if(arr[i][j] != 0 ) dfs(i, j, arr[i][j]);
            }
            copyArr();
            max = Math.max(max, tempAnswer);
            tempAnswer = 0;

            //열 이동
            for(int j = 1; j <= board.length; j++){
                if(arr[j][i] != 0 ) dfs(j, i, arr[j][i]);
            }
            copyArr();
            max = Math.max(max, tempAnswer);
        }
        answer = max;

        return answer;
    }

    private static void copyArr(){
        for(int i = 1; i <= boardLen; i++){
            for(int j = 1; j <= boardLen; j++){
                arr[i][j] = tempArr[i][j];
            }
        }
    }

    private static void dfs(int r, int c, int target){
        if(arr[r][c] == 0 || arr[r][c] != target) return;

        arr[r][c] = 0;
        tempAnswer++;
        for(int i = 0; i < delta.length; i++){
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];
            dfs(nr, nc, target);
        }
    }

}