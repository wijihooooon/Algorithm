import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list;
        int answer = 0;
        
        for(int i=0; i<tangerine.length; i++){
            int size = tangerine[i];
            if(map.containsKey(size)){
                map.put(size, map.get(size)+1);
            }else{
                map.put(size, 1);
            }
        }
        
        list = new ArrayList<>(map.values());
        Collections.sort(list);
        
        for(int i=list.size()-1; i>=0 && k>0; i--){
            int value = list.get(i);
            k -= value;
            answer++;
        }
            
        return answer;
    }
}