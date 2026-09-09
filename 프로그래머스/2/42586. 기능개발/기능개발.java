import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int[] day = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            day[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) day[i]++;
        }
        
        int main = 0;
        int ans = 0;
        for(int i=0; i<day.length; i++){
            main = day[i];
            int idx = i+1;
            ans = 1;
            while(true){
                if(idx >= day.length || main < day[idx]) break;
                ans++;
                idx++;
                i++;
            }
            list.add(ans);
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}