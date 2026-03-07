import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        answer = min + " " + max;
        return answer;
    }
}