import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        int[] hamburger = {3, 2, 1};
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int p=0; p<ingredient.length; p++){
            int whoAreYou = ingredient[p];
            
            if(whoAreYou != 1){ // 빵이 아니면 큐에 삽입
                dq.addFirst(whoAreYou);
                continue;
            }
            
            if(dq.size() < 3){
                dq.addFirst(1);
                continue;
            }
            
            boolean isBurger = true;
            int burgerN = 0;
            for(int i=0; i<3; i++){
                int ingre = dq.pollFirst();
                if(ingre != hamburger[i]){
                    isBurger = false;
                    dq.addFirst(ingre);
                    burgerN = i;
                    break;
                }
            }
            
            if(isBurger){
                answer++;
            }else{
                for(int i=burgerN-1; i>=0; i--){
                    dq.addFirst(hamburger[i]);
                }
                dq.addFirst(1);
            }
        }
        
        return answer;
    }
}