import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        
        for(int i=0; i<weights.length; i++){
            int pig = weights[i];
            
            answer += map.getOrDefault(pig, 0);

            if ((pig * 3) % 4 == 0) {
                answer += map.getOrDefault((pig * 3) / 4, 0);
            }

            if ((pig * 2) % 3 == 0) {
                answer += map.getOrDefault((pig * 2) / 3, 0);
            }

            if (pig % 2 == 0) {
                answer += map.getOrDefault(pig / 2, 0);
            }
            
            map.put(pig, map.getOrDefault(pig, 0) + 1);
        }        
        
        return answer;
    }
}