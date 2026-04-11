import java.util.*;

class Solution {
    
    public Set<Integer> set = new HashSet<>();
    public boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        comb(numbers, 0, "");
        
        for(int i : set){
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    public void comb(String numbers, int idx, String num){
        if(num != ""){
            set.add(Integer.parseInt(num));
        }
        
        if(idx == numbers.length()){
            return;
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            comb(numbers, idx+1, num + numbers.charAt(i));
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}