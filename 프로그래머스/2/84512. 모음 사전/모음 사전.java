import java.util.*;

class Solution {
    
    ArrayList<String> list = new ArrayList<>();
    char[] arr = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("");
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i+1;
            }
        }
        
        return answer;
    }
    
    public void dfs(String str){
        if(!str.equals("")){
            list.add(str);
        }
        
        if(str.length() == 5){
            return;
        }
        
        for(int i=0; i<5; i++){
            dfs(str + arr[i]);
        }
    }
}