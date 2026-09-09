import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char chr = s.charAt(i);
            if(chr == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
                continue;
            }
            stack.push(chr);
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}