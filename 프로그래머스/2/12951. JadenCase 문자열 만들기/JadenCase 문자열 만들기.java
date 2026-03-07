import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        
        for(int i=0; i<s.length(); i++){
            char chr = s.charAt(i);
            
            if(chr == ' '){
                sb.append(chr);
                isFirst = true;
            }else{
                if(isFirst){
                    sb.append(Character.toUpperCase(chr));
                    isFirst = false;
                }else{
                    sb.append(Character.toLowerCase(chr));
                }
            }
        }        
        return sb.toString();
    }
}