import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String number = Integer.toString(n, k);
        StringTokenizer num = new StringTokenizer(number, "0");
        
        while(num.hasMoreTokens()){
            String str = num.nextToken();
            
            if(isPrime(str)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(String num){
        long number = Long.parseLong(num);
        
        if(number < 2) return false;
        
        for(long i=2; i * i <= number; i++){
            if(number % i == 0) return false;
        }
        
        return true;
    }
}