import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        HashMap<Integer, Integer> leftA = new HashMap<>();
        HashMap<Integer, Integer> rightA = new HashMap<>();
        HashMap<Integer, Integer> leftB = new HashMap<>();
        HashMap<Integer, Integer> rightB = new HashMap<>();
        
        int left = topping.length / 2;
        int right = topping.length / 2;
        
        for(int i=0; i<topping.length/2; i++){
            leftA.put(topping[i], leftA.getOrDefault(topping[i], 0) + 1);
            leftB.put(topping[i], leftB.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=topping.length/2; i<topping.length; i++){
            rightA.put(topping[i], rightA.getOrDefault(topping[i], 0) + 1);
            rightB.put(topping[i], rightB.getOrDefault(topping[i], 0) + 1);
        }
        
        if(rightA.size() == leftA.size()) answer++;
        
        // 왼쪽으로 A
        for(int i=left-1; i>=0; i--){
            int top = topping[i];
            
            if(leftA.get(top) == null || leftA.get(top) == 1){
                leftA.remove(top);
            }else{
                leftA.put(top, leftA.get(top) - 1);
            }
            
            rightA.put(top, rightA.getOrDefault(top, 0) + 1);
            
            if(leftA.size() == rightA.size()) answer++;
        }
        
        // 오른쪽으로 B
        for(int i=right; i<topping.length; i++){
            int top = topping[i];
            
            if(rightB.get(top) == null || rightB.get(top) == 1){
                rightB.remove(top);
            }else {
                rightB.put(top, rightB.get(top) - 1);
            }
            
            leftB.put(top, leftB.getOrDefault(top, 0) + 1);
            
            if(leftB.size() == rightB.size()) answer++;
        }
        
        return answer;
    }
}