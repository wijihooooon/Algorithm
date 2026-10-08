import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        for(int i=0; i<weights.length; i++){
            int weight = weights[i];
            int typeA = weight * 2;
            int typeB = weight * 3;
            int typeC = weight * 4;
            
            for(int j=i+1; j<weights.length; j++){
                int other = weights[j];
                int typeD = other * 2;
                int typeE = other * 3;
                int typeF = other * 4;
                
                if(typeA == typeD || typeA == typeE || typeA == typeF ||
                   typeB == typeD || typeB == typeE || typeB == typeF ||
                   typeC == typeD || typeC == typeE || typeC == typeF
                  ) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}