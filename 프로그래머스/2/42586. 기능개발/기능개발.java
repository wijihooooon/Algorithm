import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int cnt = 0;
        for(int i=0; i<progresses.length; i++){
            int day = (100-progresses[i])/speeds[i];
            cnt = 1;
            if((100-progresses[i]) % speeds[i] != 0){
                day++;
            }
            for(int j=i+1; j<progresses.length; j++){
                if(progresses[j] + day * speeds[j] < 100){
                    break;
                }
                i++;
                cnt++;
            }
            list.add(cnt);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}