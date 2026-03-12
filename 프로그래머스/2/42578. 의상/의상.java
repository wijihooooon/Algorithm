import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> closet = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String type = clothes[i][1];
            closet.put(type, closet.getOrDefault(type, 0) + 1);
        }
        
        for(int cnt : closet.values()){
            answer *= (cnt+1);
        }
        
        return answer-1;
    }
}