import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int num = Integer.toBinaryString(n).replace("0", "").length();
        int newNum = 0;
        
        while(num != newNum){
            n++;
            newNum = Integer.toBinaryString(n).replace("0", "").length();
        }
        
        answer = n;
        return answer;
    }
}