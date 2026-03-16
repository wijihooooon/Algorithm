import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            String str1 = phone_book[i];
            String str2 = phone_book[i+1];
            
            if(str1.length() <= str2.length() && str1.equals(str2.substring(0, str1.length()))){
                return false;
            }
        }
        
        return true;
    }
}