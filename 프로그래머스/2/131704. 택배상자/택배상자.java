import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i=1, check = 0; i<=order.length; i++){
            dq.push(i);
            
            while(!dq.isEmpty() && dq.peek() == order[check]){
                dq.pop();
                check++;
                answer++;
            }            
        }
        return answer;
    }
}