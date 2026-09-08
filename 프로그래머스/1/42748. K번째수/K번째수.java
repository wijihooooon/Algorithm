import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] arr;
        
        for(int i=0; i<commands.length; i++){
            int num1 = commands[i][0];
            int num2 = commands[i][1];
            int num3 = commands[i][2];
            
            arr = new int[num2-num1+1];

            for(int l=0, m=num1-1; l<num2-num1+1; l++, m++){
                arr[l] = array[m];
            }
            
            Arrays.sort(arr);
            
            answer[i] = arr[num3-1];
        }
        
        return answer;
    }
}