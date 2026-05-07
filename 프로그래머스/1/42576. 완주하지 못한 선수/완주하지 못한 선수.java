import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }
        
        for(int i=0; i<completion.length; i++){
            String name = completion[i];
            
            if(!map.containsKey(name)) continue;
            
            if(map.get(name) > 1){
                map.put(name, map.get(name)-1);
            }else{
                map.remove(name);
            }
        }
        
        for(String name : map.keySet()){
            return name;
        }
        
        return answer;
    }
}