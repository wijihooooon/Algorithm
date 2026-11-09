import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = sequence[start];
        
        if (sum == k) {
            return new int[] {0, 0};
        }
        
        while(start != sequence.length - 1){
            
            if(sum > k){
                sum -= sequence[start];
                start++;
            }else{
                if(end == sequence.length-1) break;
                end++;
                sum += sequence[end];
            }
            
            if(sum == k && end - start < minLength){
                minLength = end - start;
                answer[0] = start;
                answer[1] = end;
            }
            
        }
        
        return answer;
    }
}