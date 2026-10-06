import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, (a, b) ->{
            String headA = findHead(a);
            String headB = findHead(b);
            int numberA = findNumber(a);
            int numberB = findNumber(b);
            
            
            int headCompare = headA.compareToIgnoreCase(headB);

            if (headCompare != 0) {
                return headCompare;
            }

            return numberA - numberB;
        });
        
        answer = files;
        
        return answer;
    }
    
    public String findHead(String str){
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i != str.length() && !(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
            sb.append(str.charAt(i));
            i++;
        }
        
        return sb.toString();
    }
    
    public int findNumber(String str){
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        boolean isNumber = false;
        
        while(true){
            
            if(i == str.length() || (isNumber && !(str.charAt(i) >= '0' && str.charAt(i) <= '9'))){
                break;
            }
            
            if(isNumber){
                sb.append(str.charAt(i));
                i++;
                continue;
            }
            
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                isNumber = true;
                sb.append(str.charAt(i));
            }
            i++;
        }
            return Integer.parseInt(sb.toString());
        }
}