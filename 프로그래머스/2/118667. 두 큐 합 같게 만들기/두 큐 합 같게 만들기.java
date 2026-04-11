import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        int size = (queue1.length + queue2.length) * 2;
        long sumA = 0;
        long sumB = 0;
        Deque<Integer> dqA = new ArrayDeque<>();
        Deque<Integer> dqB = new ArrayDeque<>();
        
        for(int i=0; i<queue1.length; i++){
            sumA += queue1[i];
            dqA.offerLast(queue1[i]);
        }
        
        for(int i=0; i<queue2.length; i++){
            sumB += queue2[i];
            dqB.offerLast(queue2[i]);
        }
        
        for(int i=0; i<size; i++){
            
            if(sumA > sumB){
                int num = dqA.pollFirst();
                sumB += num;
                sumA -= num;
                dqB.offerLast(num);
            }else if(sumA < sumB){
                int num = dqB.pollFirst();
                sumA += num;
                sumB -= num;
                dqA.offerLast(num);
            }else{
                break;
            }
            
            answer++;      
        }
        
        if(sumA != sumB){
            answer = -1;
        }
        
        return answer;
    }
}