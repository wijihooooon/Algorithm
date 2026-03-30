import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(char c='A'; c<='Z'; c++){
            map.put(String.valueOf(c), c - 'A' + 1);
        }
        
        for(int i=0, idx = 'Z' - 'A' + 1; i<msg.length(); i++){         
            for(int j=i; j<msg.length(); j++){
                String str = msg.substring(i,j+1);
                if(!map.containsKey(str)){
                    list.add(map.get(msg.substring(i, j)));
                    map.put(str, ++idx);
                    i=j-1;
                    break;
                }
                
                if (j == msg.length() - 1) {
                    list.add(map.get(str));
                    i = j;
                    }
            }
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}