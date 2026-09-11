import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 마지막 공격 시간
        int totalTime = attacks[attacks.length-1][0];
        int hp = health; // 체력
        int bonusHeal = 0; // 추가 힐
        
        int attackIdx = 0;
        for(int i=0; i<=totalTime; i++){
            
            if(attacks[attackIdx][0] == i){ //공격당함
                hp -= attacks[attackIdx][1];
                bonusHeal = 0;
                attackIdx++; // 공격용 index 증가
                if(hp <= 0 ) {
                    return -1;
                }
            }else{ // 공격안당함
                bonusHeal++;
                hp += bandage[1]; // 기본 회복
                if(bonusHeal == bandage[0]){
                    hp += bandage[2]; // t초째 추가 회복
                    bonusHeal = 0; // 보너스 힐 여부 초기화
                }
                
                hp = Math.min(hp, health);
            }
        }
        return hp;
    }
}