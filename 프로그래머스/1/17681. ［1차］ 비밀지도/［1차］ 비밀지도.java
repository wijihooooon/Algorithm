import java.util.*;

class Solution {
    
    public static int n;
    public static StringBuilder sb;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        Solution.n = n;
        
        String[] strArr1;
        String[] strArr2;
        
        strArr1 = toBinary(arr1);
        strArr2 = toBinary(arr2);
        
        String ans = "";
        
        for(int i=0; i<n; i++){
            String str1 = strArr1[i];
            String str2 = strArr2[i];
            for(int j=0;j<n; j++){
                if(str1.charAt(j) == '1' || str2.charAt(j) == '1'){
                    ans += '#';
                    continue;
                }
                ans += " ";
            }
            answer[i] = ans;
            ans = "";
        }
        
        return answer;
    }
    
    public static String[] toBinary(int[] arr){
        String[] strArr = new String[n];
        for(int i=0; i<n; i++){
            sb = new StringBuilder();
            
            int num = arr[i];
            
            while(num > 0){
                sb.append(num%2);
                num /= 2;
            }
            
            for(int j=sb.length(); j<n; j++){
                sb.append('0');
            }
            sb.reverse();
            strArr[i] = sb.toString();
        }
        return strArr;
    }
}