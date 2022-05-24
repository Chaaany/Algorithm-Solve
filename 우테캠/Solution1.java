package 우테캠;

import java.io.*;
import java.util.*;

class Solution1 {
    public int solution(int[][] salaries, int days) {
        int answer = 0;

        for(int i = 0; i < salaries.length; i++ ){
            int interval = salaries[i][0];
            int single = salaries[i][1];
            answer += (int)Math.ceil(1.0 * days / interval) * single;
        }

        return answer;
    }
}