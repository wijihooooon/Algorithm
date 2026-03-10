import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++){ // 길이
            for(int j=0; j<elements.length; j++){ // 시작점
                int sum = 0;
                for(int k=j; k<j+i; k++){ // 시작점 ~ 길이만큼 더하기
                    int val = k % elements.length; // 초과하는 경우 대비
                    sum += elements[val];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}