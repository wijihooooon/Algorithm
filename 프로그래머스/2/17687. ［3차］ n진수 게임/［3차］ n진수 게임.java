import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while(sb.length() <= t*m){
            sb.append(Integer.toString(num, n).toUpperCase());
            num++;
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<t; i++){
            answer.append(sb.charAt((p-1) + i * m));
        }
        
        return answer.toString();
    }
}