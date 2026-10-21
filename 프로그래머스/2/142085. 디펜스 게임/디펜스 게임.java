import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for(int i=0; i<enemy.length; i++){
            pq.add(enemy[i]);
            n -= enemy[i];
            
            if(n<0){
                if(k == 0) break;
                
                n += pq.poll();
                k--;
            }
            answer++;
        }        

        return answer;
    }
}