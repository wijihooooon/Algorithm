import java.util.*;

class Solution {
    
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        
        for(int i=0; i<answer.length; i++){
            long start = left + i;
            int row = (int)(start/n);
            int col = (int)(start%n);
            answer[i] = Math.max(row, col) + 1;
        }
        
        return answer;
    }
}