import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            StringBuilder number = toBinary(numbers[i]);
            String num = number.toString();
            
            for(int j=num.length()-1; j>=0; j--){
                
                char n = num.charAt(j);
                
                if(j == num.length()-1 && n == '0'){
                    number.setCharAt(num.length()-1, '1');
                    break;
                }else if(j == 0 && n == '1'){
                    number.insert(0, '1');
                    number.setCharAt(1, '0');
                }else if(n == '0'){
                    number.setCharAt(j, '1');
                    number.setCharAt(j+1, '0');
                    break;
                }
            }
            answer[i] = toDecimal(number.toString());   
        }
        
        return answer;
    }
    
    public StringBuilder toBinary(long num){
        StringBuilder sb = new StringBuilder();
        
        long number = num;
        if(number == 0){
            sb.append(0);
            return sb;
        }
        while(number != 0){
            if(number % 2 == 1){
                sb.append(1);
            }else{
                sb.append(0);
            }
            
            number /= 2;
        }
        
        return sb.reverse();
    }
    
    public long toDecimal(String num){
        long sum = 0;
        long mul = 1;
        
        for(int i=num.length()-1; i>=0; i--){
            if(num.charAt(i) == '1'){
                sum += mul;
            }
            
            mul *= 2;
        }
        
        return sum;
    }
}