import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n!=0 && pq.peek() != 0){
            pq.offer(pq.poll() - 1);
            n--;
        }
        
        if(pq.peek() == 0){
            return 0;
        }

        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}