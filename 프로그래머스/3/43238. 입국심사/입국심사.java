import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 1;
        long right = n * (long) times[times.length - 1];
        
        while(left <= right){
            long mid = (left + right) / 2;
            long people = 0;
            
            for(int time : times){
                people += mid / time;
            }
            
            if(people >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;   
            }
        }
        return answer;
    }
}