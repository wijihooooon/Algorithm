import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int answerL = 0;
        int answerR = sequence.length-1;
        
        while(left < sequence.length && right < sequence.length){
            
            if(sum == k){
                if(right-left < answerR-answerL){
                    answerR = right;
                    answerL = left;
                }
                sum -= sequence[left];
                left++;
            }else if(sum < k){
                right++;
                if(right < sequence.length){
                    sum += sequence[right];   
                }
            }else{
                sum -= sequence[left];
                left++;
            }
        }
        
        answer[0] = answerL;
        answer[1] = answerR;
        
        return answer;
    }
}