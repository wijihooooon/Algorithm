import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int cnt = 0;
        Deque<Integer> monotonicStack = new ArrayDeque<>();
        monotonicStack.offerFirst(number.charAt(0) - '0');
        
        for(int i=1; i<number.length(); i++){
            
            while(cnt != k && !monotonicStack.isEmpty() && monotonicStack.peek() < number.charAt(i) - '0'){
                monotonicStack.pop();
                cnt++;
            }
            
            monotonicStack.offerFirst(number.charAt(i) - '0');
        }
        
        while(!monotonicStack.isEmpty()){
            answer += String.valueOf(monotonicStack.pollLast());
        }
        
        if(cnt != k){
            answer = answer.substring(0, answer.length() - (k - cnt));
        }
        
        return answer;
    }
}