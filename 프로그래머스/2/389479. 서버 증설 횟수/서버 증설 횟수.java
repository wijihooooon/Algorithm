import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            dq.add(0);
        }
        
        int currentServer = 0;
        int limit = 0;
        
        for(int i=0; i<players.length; i++){
            int people = players[i];
            int offServer = dq.poll();
            if(offServer != 0) currentServer -= offServer;
            
            limit = (currentServer + 1) * m;
            
            int addServer = 0;
            while(limit <= people){
                addServer++;
                currentServer++;
                answer++;
                limit = (currentServer + 1) * m;
            }
            
            dq.add(addServer);
        }
        return answer;
    }
}