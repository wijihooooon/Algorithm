import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0; // 지나가는대 걸리는 시간
        int bridgeWeight = 0; // 다리에 걸리는 부하
        int truckCnt = 0; // 다리위에 올라가있는 트럭의 수
        int arrivedTruckCnt = truck_weights.length;
        int waitingTruckIdx = 0;
        
        Deque<Integer> bridge = new ArrayDeque<>();
        
        // 트럭이 올라가지 않은 빈 공간을 0으로 표현
        for(int i=0; i<bridge_length; i++){
            bridge.offerLast(0); 
        }
        
        while(arrivedTruckCnt != 0){
            
            // 다리에서 트럭 내리는거
            if(truckCnt >= 0){
                int truck = bridge.pollFirst();
                
                if(truck != 0){ // 트럭이 나왔다
                    bridgeWeight -= truck;
                    arrivedTruckCnt--;
                    truckCnt--;
                }
            }
            
            // 다리에 트럭 올라타는거
            if(truckCnt < bridge_length &&
               waitingTruckIdx < truck_weights.length &&
               bridgeWeight + truck_weights[waitingTruckIdx] <= weight){
                
                bridge.offerLast(truck_weights[waitingTruckIdx]);  // 다리위에 새 트럭 올림
                bridgeWeight += truck_weights[waitingTruckIdx]; // 다리 위 무게 최신화
                truckCnt++;                                    // 다리위 트럭 +1
                waitingTruckIdx++;                             // 대기 트럭 인덱스 +1
                
            }else{
                bridge.offerLast(0); // 트럭이 올라가지 못하는 경우 0
            }
            time++; // 시간 증가
        }
        
        answer = time;
        
        return answer;
    }
}