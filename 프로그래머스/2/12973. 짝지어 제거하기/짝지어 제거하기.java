import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> dq = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char chr = s.charAt(i);
            
            if(!dq.isEmpty() && dq.peekLast() == chr){
                dq.pollLast();
            }else{
                dq.offerLast(chr);
            }
        }
        
        return dq.isEmpty() ? 1 : 0;
    }
}