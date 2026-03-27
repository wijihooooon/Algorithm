import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int before = pq.peek();
        while(!pq.isEmpty() && pq.size() > 1 && pq.peek() < K){
            int chilli = pq.poll();
            int pepper = pq.poll();
            
            pq.offer(chilli + pepper * 2);
            answer++;
        }
        if(pq.size() == 1 && pq.poll() < K) answer = -1;
        return answer;
    }
}