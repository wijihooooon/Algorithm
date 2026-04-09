import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees){
            int idx = 0;
            boolean valid = true;
            
            for(int i=0; i<tree.length(); i++){
                char ch = tree.charAt(i);
                
                if(skill.indexOf(ch) == -1) continue;

                if(ch != skill.charAt(idx)){
                    valid = false;
                    break;
                }
                
                idx++;
                
                if(idx == skill.length()) break;
            }
            
            if(valid) answer++;
        }
        
        return answer;
    }
}