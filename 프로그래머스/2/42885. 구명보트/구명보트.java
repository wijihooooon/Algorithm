import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            if(people[right] + people[left] <= limit){
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}