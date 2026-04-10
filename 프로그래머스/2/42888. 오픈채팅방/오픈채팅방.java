import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> userNickNameList = new HashMap<>();
        ArrayList<String> log = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
            String str = record[i];
            
            StringTokenizer st = new StringTokenizer(str);
            String type = st.nextToken();
            String id = st.nextToken();
            
            if(type.equals("Enter")){
                log.add(id + "님이 들어왔습니다.");
                userNickNameList.put(id, st.nextToken());
            }else if(type.equals("Leave")){
                log.add(id + "님이 나갔습니다.");
            }else if(type.equals("Change")){
                userNickNameList.put(id, st.nextToken());
            }         
        }
        
        answer = new String[log.size()];
        
        for(int i=0; i<log.size(); i++){
            String str = log.get(i);
            
            int idx = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '님') {
                    idx = j;
                    break;
                }
            }
            
            String id = str.substring(0, idx);   
            answer[i] = str.replace(id, userNickNameList.get(id));
        }
        
        return answer;
    }
}