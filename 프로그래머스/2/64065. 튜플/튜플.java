import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i) == '{'){
                List<Integer> li = new ArrayList<>();
                String str = "";
                i++;
                
                while(s.charAt(i) != '}'){
                    if(s.charAt(i) != ','){
                        str += s.charAt(i);
                    }else{
                        li.add(Integer.parseInt(str));
                        str = "";
                    }
                    i++;
                }
                li.add(Integer.parseInt(str));
                list.add(li);
            }
        }
        
        list.sort((a, b) -> a.size() - b.size());
        
        int[] answer = new int[list.size()];
        Set<Integer> seen = new HashSet<>();
        
        
        int cnt = 0;
        
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++){
                if(!seen.contains(list.get(i).get(j))){
                    seen.add(list.get(i).get(j));
                    answer[cnt++] = list.get(i).get(j);
                    break;
                }
            }
        }
        
        
        return answer;
    }
}