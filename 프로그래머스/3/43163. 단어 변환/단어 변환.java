import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean visited[] = new boolean[words.length];
        Deque<Node> dq = new ArrayDeque<>();
        dq.addFirst(new Node(begin, 0));
        
        while(!dq.isEmpty()){
            Node node = dq.pollLast();
            
            if(node.word.equals(target)){
                return node.count;
            }
            
            for(int i=0; i<words.length; i++){
                if(visited[i] || !canChange(node.word, words[i])) continue;
                
                visited[i] = true;
                dq.addFirst(new Node(words[i], node.count + 1));
            }
        }
        
        return answer;
    }
    
    public boolean canChange(String now, String next){
        int diff = 0;
        
        for(int i=0; i<now.length(); i++){
            if(now.charAt(i) != next.charAt(i)){
                diff++;
            }
            
            if(diff > 1){
                return false;
            }
        }
        
        return true;
    }
    
    public class Node{
        String word;
        int count;
        
        public Node(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}