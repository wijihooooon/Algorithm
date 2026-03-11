import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Deque<Character> dq;
        for(int i=0; i<s.length(); i++){
            dq = new ArrayDeque<>();
            boolean check = false;
            
            for(int j=0; j<s.length(); j++){
                char chr1 = s.charAt(j);
                
                if(chr1 == '(' || chr1 == '{' || chr1 == '['){
                    dq.offerLast(chr1);
                }else{
                    if(dq.isEmpty()){
                        check = true;
                        break;
                    }
                
                    char chr2 = dq.removeLast();
                    if ((chr1 == ')' && chr2 != '(') ||
                            (chr1 == '}' && chr2 != '{') ||
                            (chr1 == ']' && chr2 != '[')) {
                            check = true;
                            break;
                    }
                }   
            }
            
            char temp = s.charAt(0);
            s = s.substring(1, s.length());
            s += temp;
            
            if(!check && dq.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}