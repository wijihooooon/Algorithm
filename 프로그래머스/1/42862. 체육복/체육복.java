import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        Set<Integer> victim = new HashSet<>();
        Set<Integer> thief = new HashSet<>();
        
        for(int i=0; i<lost.length; i++){
            victim.add(lost[i]);
        }
        
        for(int i=0; i<reserve.length; i++){
            if(victim.contains(reserve[i])){
                victim.remove(reserve[i]);
            }else{
                thief.add(reserve[i]);   
            }
        }
        
        for(int i=1; i<=n; i++){
            if(victim.contains(i) && thief.contains(i-1)){
                thief.remove(i-1);
                continue;
            }else if(victim.contains(i) && thief.contains(i+1)){
                thief.remove(i+1);
                continue;
            }else if(victim.contains(i)){
                answer--;
            }
        }
        
        return answer;
    }
}