import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<int[]> dq = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++){
            dq.addLast(new int[] {i, priorities[i]});
        }
        
        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            
            boolean hasHigher = false;
            
            for(int[] process : dq){
                if(cur[1] < process[1]){
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher){
                dq.addLast(cur);
            }else{
                answer++;
                if(cur[0] == location){
                return answer;
            }
            }
        }
        return answer;
    }
}