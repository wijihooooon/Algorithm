import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++){

            int ans = answers[i];
            
            if(ans == p1[i%5]){
                score[0]++;
            }
            
            if(ans == p2[i%8]){
                score[1]++;
            }
            
            if(ans == p3[i%10]){
                score[2]++;
            }
        }
        
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            if(maxScore == score[i]){
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}