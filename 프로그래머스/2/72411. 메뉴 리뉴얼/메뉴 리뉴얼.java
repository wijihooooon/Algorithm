import java.util.*;

class Solution {
    
    public HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for(int i=0; i<orders.length; i++){
            char[] chrs = orders[i].toCharArray();
            Arrays.sort(chrs);
            
            String str = new String(chrs);
            
            for(int j=0; j<course.length; j++){
                findMenu(str, course[j], 0, "");
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for(int length : course){
            int max = 0;
            
            // 현재 길이중 최대인 조합 탐색
            for(String menu : map.keySet()){
                if(menu.length() == length){
                    max = Math.max(max, map.get(menu));
                }
            }
            
            if(max < 2){
                continue;
            }
            
            for(String menu : map.keySet()){
                if(menu.length() == length && map.get(menu) == max){
                    result.add(menu);
                }
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[0]);
    }
    
    public void findMenu(String order, int target, int start, String selected){
        if(target == 0){
            map.put(selected, map.getOrDefault(selected, 0) + 1);
            return;
        }
        
        for(int i=start; i<order.length(); i++){
            findMenu(order, target-1, i+1, selected + order.charAt(i));
        }
    }
}