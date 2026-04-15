import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int size = String.valueOf(storey).length();
        
        while(storey>0){
            int checkNum = (storey % 10);
            int nextNum = (storey / 10) % 10;
            storey /= 10;
            
            if(checkNum > 5){
                answer += 10 - checkNum;
                storey++;
            }else if(checkNum < 5){
                answer += checkNum;
            }else if(checkNum == 5){
                answer += 5;
                if(nextNum >= 5){
                    storey++;
                }
            }
        }
        
        return answer;
    }
}