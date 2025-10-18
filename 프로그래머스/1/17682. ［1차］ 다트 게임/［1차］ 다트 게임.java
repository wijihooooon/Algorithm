import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] point = new int[3];
        
        int cnt = 0;
        
        for(int i=0; i<dartResult.length(); i++){
            char order = dartResult.charAt(i);
            
            if(order-'0'>= 0 && order-'0'<=9){
                
                int num = order-'0';
                
                if(num == 1 && dartResult.charAt(i+1) == '0'){
                    i++;
                    num = 10;
                }
                
                char spot = dartResult.charAt(++i);
                if(spot == 'S'){
                    num = (int) Math.pow(num, 1);
                }else if(spot == 'D'){
                    num = (int) Math.pow(num, 2);
                }else if(spot == 'T'){
                    num = (int) Math.pow(num, 3);
                }
                
                point[cnt] = num;
                cnt++;
                
            }else if(order == '*'){
                point[cnt-1] *= 2;
                
                if(cnt == 1) continue;
                
                point[cnt-2] *= 2;
            }else if(order == '#'){
                point[cnt-1] *= -1;
            }
        }
        
        for(int score: point){
            answer += score;
        }
        
        return answer;
    }
}