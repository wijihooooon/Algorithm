import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(0);
    
        for(int i=1; i<prices.length; i++){
            int price = prices[i];
            int size = dq.size();
            
            for(int j=0; j<size; j++){
                int idx = dq.pollFirst();
                answer[idx]++;
                if(prices[idx] <= price){
                    dq.offerLast(idx);
                }
            }
            dq.offerLast(i);
        }
        
        return answer;
    }
}