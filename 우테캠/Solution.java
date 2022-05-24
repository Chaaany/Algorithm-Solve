package 우테캠;

import java.util.*;
import java.io.*;

class Solution {
    static String nToS[][] = {
    {"O", "()", "0"}, 
    {"I", "1"}, 
    {"Z", "S", "7_", "2"}, 
    {"B", "E", "3"}, 
    {"A", "4"}, 
    {"Z", "S", "5"}, 
    {"b", "G", "6"}, 
    {"T", "Y", "7"}, 
    {"B", "E3", "8"}, 
    {"g", "q", "9"}
    };

    static LinkedHashSet<String> lhs;
    public int[] solution(String[] numstrs, String[] words) {
        int[] answer = new int[words.length];

        for(int i = 0; i < words.length; i++){
            lhs = new LinkedHashSet<>();

            // 3, 8 : B 겹침 / && 2, 5 : Z, S 겹침
            numToStr(0, words[i].length(), words[i], new String[words[i].length()]);

            for(String str : lhs){
                for(int j = 0; j < numstrs.length; j++){
                    if(numstrs[j].contains(str))answer[i]++;
                }
            }
        }

        return answer;
    }

    private static void numToStr(int cnt, int N, String words, String[] modifiedStr){
        if(cnt == N){
            boolean chk[] = new boolean[6];

            for(int i = 0; i < modifiedStr.length; i++){
                int number = words.charAt(i) - '0';
                if(number == 3 || number == 8){
                    if(number == 3 && modifiedStr[i].equals("B") && chk[1]){
                        return;
                    }else if(number == 3 && modifiedStr[i].equals("B") && !chk[1]){
                        chk[0] = true;
                    }
                    if(number == 8 && modifiedStr[i].equals("B") && chk[0]){
                        return;
                    }else if(number == 8 && modifiedStr[i].equals("B") && !chk[0]){
                        chk[1] = true;
                    }
                }

                if(number == 2 || number == 5){
                    if(number == 2 && modifiedStr[i].equals("Z") && chk[3]){
                        return;
                    }else if(number == 2 && modifiedStr[i].equals("Z") && !chk[3]){
                        chk[2] = true;
                    }
                    if(number == 5 && modifiedStr[i].equals("Z") && chk[2]){
                        return;
                    }else if(number == 5 && modifiedStr[i].equals("Z") && !chk[2]){
                        chk[3] = true;
                    }
                }

                if(number == 2 || number == 5){
                    if(number == 2 && modifiedStr[i].equals("S") && chk[5]){
                        return;
                    }else if(number == 2 && modifiedStr[i].equals("S") && !chk[5]){
                        chk[4] = true;
                    }
                    if(number == 5 && modifiedStr[i].equals("S") && chk[4]){
                        return;
                    }else if(number == 5 && modifiedStr[i].equals("S") && !chk[4]){
                        chk[5] = true;
                    }
                }                
            }
            String temp = "";
            for(int i = 0; i < modifiedStr.length; i++){
                temp += modifiedStr[i];
            }
            lhs.add(temp);
            return;
        }

        int number = words.charAt(cnt) -'0'; 
        for(int j = 0; j < nToS[number].length; j++){
            modifiedStr[cnt] = nToS[number][j];
            numToStr(cnt +1, N, words, modifiedStr);
        }
    }
}