import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxL = 0;
        int maxR = 0;
        for(int i=0; i<sizes.length; i++){
               if(sizes[i][0] > sizes[i][1]){
                   maxL = Math.max(maxL, sizes[i][0]);
                   maxR = Math.max(maxR, sizes[i][1]);
               }else{
                   maxL = Math.max(maxL, sizes[i][1]);
                   maxR = Math.max(maxR, sizes[i][0]);
               }
        }
        answer = maxL * maxR;
        
        return answer;
    }
}