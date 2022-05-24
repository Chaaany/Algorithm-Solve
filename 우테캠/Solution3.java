package 우테캠;

import java.util.*;
import java.io.*;

class Solution3 {
    public int[] solution(int[][] scores) {
        int[] answer = new int[scores.length];
        // 1번 총점, 2번 어려운 문제 더 높은 점수 받은 사람(총점이 문제가 어려운 문제) 3. ID번호가 빠른 응시자
        // 1번으로 정렬하기 총점 구하기
        int[][] tempScores = new int[scores.length][4];     
        int firstProblemTotal = 0;
        int secondProblemTotal = 0;
        for(int i = 0; i < scores.length; i++){
            tempScores[i][0] = scores[i][0]+ scores[i][1]; // 총점
            tempScores[i][1] = scores[i][0]; // 첫 번 째 문제
            tempScores[i][2] = scores[i][1]; // 두 번 째 문제
            tempScores[i][3] = i+1; // 아이디
            firstProblemTotal += scores[i][0];
            secondProblemTotal += scores[i][1];
        }

        if(firstProblemTotal < secondProblemTotal){ // 첫 번 째 문제가 어려운 문제
            Arrays.sort(tempScores, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0] == b[0]){ // 총점으로 비교 불가능
                        if(a[1] == b[1]){ // 첫 번째 문제 점수로 비교 불가능
                            return a[3]- b[3]; // ID가 빠른 순
                        }else { // 첫 번째 문제 점수로 비교 가능
                            return b[1] - a[1]; // 점수 높은 순
                        }
                    }else { // 총점으로 비교 가능
                        return b[0] - a[0]; // 점수 높은 순
                    }
                }
            });
        }else if(firstProblemTotal > secondProblemTotal){ // 두 번 째 문제가 어려운 문제
            Arrays.sort(tempScores, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0] == b[0]){ // 총점으로 비교 불가능
                        if(a[2] == b[2]){ // 두 번째 문제 점수로 비교 불가능
                            return a[3]- b[3]; // ID가 빠른 순
                        }else { // 두 번째 문제 점수로 비교 가능
                            return b[2] - a[2]; // 점수 높은 순
                        }
                    }else { // 총점으로 비교 가능
                        return b[0] - a[0]; // 점수 높은 순
                    }
                }
            });            
        }else{
            Arrays.sort(tempScores, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0] == b[0]){ // 총점으로 비교 불가능
                        return a[3]- b[3]; // ID가 빠른 순
                    }else { // 총점으로 비교 가능
                        return b[0] - a[0]; // 점수 높은 순
                    }
                }
            });
        }

        for(int i = 0; i < tempScores.length; i++){
            answer[tempScores[i][3]-1] = i+1;
        }

        return answer;
    }
}