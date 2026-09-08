import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxLeft = 0;
        int maxRight = 0;
        
        for(int i=0; i<sizes.length; i++){
            int left = sizes[i][0];
            int right = sizes[i][1];
            
            if(left < right){
                maxLeft = Math.max(maxLeft, right);
                maxRight = Math.max(maxRight, left);
            }else{
                maxLeft = Math.max(maxLeft, left);
                maxRight = Math.max(maxRight, right);
            }
        }
        
        answer = maxLeft * maxRight;
        
        return answer;
    }
}