import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        List<Integer> numberA = calYaksu(arrayA[0]);
        List<Integer> numberB = calYaksu(arrayB[0]);
        
        int A = cal(numberA, arrayA, arrayB);
        int B = cal(numberB, arrayB, arrayA);
       
        answer = Math.max(A, B); 
        
        return answer;
    }
    
    public List<Integer> calYaksu(int number){
        List<Integer> list = new ArrayList<>();
        
        for(int i=2; i<=number; i++){
            if(number % i == 0){
                list.add(i);
            }
        }
        
        return list;
    }
    
    public int cal(List<Integer> yaksu, int[] arrayA, int[] arrayB){
        int answer = 0;
        for(int i=yaksu.size()-1; i>=0; i--){
            int num = yaksu.get(i);
            int cnt = 0;
            for(int j=0; j<arrayA.length; j++){
                if(arrayA[j] % num != 0){
                    break;
                }
                cnt++;
            }
            if(cnt == arrayA.length){
                cnt = 0;
                for(int j=0; j<arrayB.length; j++){
                    if(arrayB[j] % num == 0){
                        break;
                    }
                    cnt++;
                }
            }
            
            if(cnt == arrayB.length){
                answer = num;
                return answer;
            }
        }
        
        return answer;
    }
}