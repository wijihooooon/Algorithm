import java.util.*;

class Solution {
    
    public Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        comb(numbers, visited, "");
        
        int answer = 0;
        
        for(int n : set){
            if(isPrime(n)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void comb(String numbers, boolean[] visited, String current){
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            
            comb(numbers, visited, current + numbers.charAt(i));
            
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num){
        
        if (num < 2) {
            return false;
        }
        
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}