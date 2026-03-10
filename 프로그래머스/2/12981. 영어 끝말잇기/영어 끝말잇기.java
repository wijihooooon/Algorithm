import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        for(int i=0; i<words.length-1; i++){
            char chr1 = words[i].charAt(words[i].length()-1);
            char chr2 = words[i+1].charAt(0);
            
            if(chr1 != chr2 || map.containsKey(words[i+1])){
                return new int[] {((i+1) % n) + 1, ((i+1)/n)+1};
            }
            map.put(words[i+1], 1);
        }

        return new int[] {0, 0};
    }
}