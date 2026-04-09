import java.util.*;

class Solution {    
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<Integer, Integer> total = new HashMap<>();
        HashMap<Integer, String> parkingLog = new HashMap<>();
        StringTokenizer rec;
        
        for(int i=0; i<records.length; i++){
            rec = new StringTokenizer(records[i]);
            String time = rec.nextToken();
            int number = Integer.parseInt(rec.nextToken());
            String type = rec.nextToken();
            
            if(type.equals("IN")){
                parkingLog.put(number, time);
            }else{
                String in = parkingLog.get(number);
                parkingLog.remove(number);
                
                int M = Integer.parseInt(time.substring(0,2)) * 60 + 
                    Integer.parseInt(time.substring(3,5)) - 
                    Integer.parseInt(in.substring(0,2)) * 60 -
                    Integer.parseInt(in.substring(3,5));
                
                total.put(number, total.getOrDefault(number, 0) + M);
            }
        }
        
        // 23:59분 출차 차량
        for(int number : parkingLog.keySet()){
            String in = parkingLog.get(number);
            int M = 1439 - Integer.parseInt(in.substring(0,2)) * 60 -
                Integer.parseInt(in.substring(3,5));
            
            total.put(number, total.getOrDefault(number, 0) + M);
        }
        
        List<Integer> carNumbers = new ArrayList<>(total.keySet());
        Collections.sort(carNumbers);
        
        int[] answer = new int[carNumbers.size()];
        
        for(int i=0; i<answer.length; i++){
            int number = carNumbers.get(i);
            int minute = total.get(number);
            
            int fee = fees[1];
            int extra = minute - fees[0];
            
            // 추가요금
            if(extra > 0 ){
                // 단위 시간 계산
                int unit = extra / fees[2];
                // 올림
                if(extra % fees[2] != 0) unit++;
                
                // 단위 시간당 단위 요금 계산
                fee += unit * fees[3];
            }
            
            answer[i] = fee;
        }
        
        return answer;
    }
}