import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        HashMap<String, Integer> saleMap = new HashMap<>();
        for(int i=0; i<10; i++){
            String item = discount[i];
            saleMap.put(item, saleMap.getOrDefault(item, 0) + 1);
        }
        
        if (wantMap.equals(saleMap)) {
            answer++;
        }
        
        for (int i = 10; i < discount.length; i++) {
            String removeItem = discount[i - 10];
            saleMap.put(removeItem, saleMap.get(removeItem) - 1);
            if (saleMap.get(removeItem) == 0) {
                saleMap.remove(removeItem);
            }

            String addItem = discount[i];
            saleMap.put(addItem, saleMap.getOrDefault(addItem, 0) + 1);

            if (wantMap.equals(saleMap)) {
                answer++;
            }
        }
        
        return answer;
    }
}