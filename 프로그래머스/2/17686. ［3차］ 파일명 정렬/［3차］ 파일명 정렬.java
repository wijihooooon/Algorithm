import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, (a, b) -> {
            String[] strA = calStr(a);
            String[] strB = calStr(b);

            if(strA[0].equals(strB[0])){
                return Integer.parseInt(strA[1]) - Integer.parseInt(strB[1]);
            }else{
                return strA[0].compareTo(strB[0]);
            }
        });
            
        answer = files;
        
        return answer;
    }
    
    public String[] calStr(String str){
        String[] answer = new String[2];
        boolean isNumber = false;
        int st = 0;
        for(int i=0; i<str.length(); i++){
                if(!isNumber && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    st = i;
                    answer[0] = str.substring(0, st).toUpperCase();
                    isNumber = true;
                }
            
                if(isNumber && (str.charAt(i) < '0' || str.charAt(i) > '9')){
                    answer[1] = str.substring(st, i);
                    break;
                }
            }
        if(answer [1] == null){
            answer[1] = str.substring(st, str.length());
        }
        return answer;
    }
}