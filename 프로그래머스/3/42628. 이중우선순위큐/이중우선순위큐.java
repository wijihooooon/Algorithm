import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=0; i<operations.length; i++){
            String str = operations[i];
            
            if(str.equals("D 1")){
                if(map.isEmpty()) continue;
                
                int key = map.lastKey();
                if(map.get(key) == 1){
                    map.remove(key);
                }else{
                    map.put(key, map.get(key) - 1);
                }
                
            }else if(str.equals("D -1")){
                if(map.isEmpty()) continue;
                
                int key = map.firstKey();
                if(map.get(key) == 1){
                    map.remove(key);
                }else{
                    map.put(key, map.get(key) - 1);
                }
            }else{
                int num = Integer.parseInt(str.substring(2, str.length()));
                
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        if(map.isEmpty()){
            return answer;
        }
        
        answer[0] = map.lastKey();
        answer[1] = map.firstKey();
        
        return answer;
    }
}