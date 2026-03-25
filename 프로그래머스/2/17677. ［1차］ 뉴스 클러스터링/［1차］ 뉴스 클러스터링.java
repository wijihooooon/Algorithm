import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int n = 0;
        int u = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        HashMap<String, Integer> A = new HashMap<>();
        HashMap<String, Integer> B = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if(a < 'a' || a > 'z' || b < 'a' || b > 'z') continue;
            
            String str = "" + a + b;
            A.put(str, A.getOrDefault(str, 0) + 1);
        }
        
        for(int i=0; i<str2.length()-1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if(a < 'a' || a > 'z' || b < 'a' || b > 'z') continue;
            
            String str = "" + a + b;
            B.put(str, B.getOrDefault(str, 0) + 1);
        }
        
        Set<String> keys = new HashSet<>();
        keys.addAll(A.keySet());
        keys.addAll(B.keySet());
        
        for (String key : keys) {
            int aCount = A.getOrDefault(key, 0);
            int bCount = B.getOrDefault(key, 0);
            
            n += Math.min(aCount, bCount);
            u += Math.max(aCount, bCount);
        }
        
        if (u == 0) return 65536;
        
        answer = (int) ((double) n / u * 65536);
        
        return answer;
    }
}