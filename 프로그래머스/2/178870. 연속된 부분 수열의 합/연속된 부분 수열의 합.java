import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        List<int[]> list = new ArrayList<>();
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        while(!(right == sequence.length-1 && sum < k)){
            if(sum < k){
                right++;
                sum += sequence[right];
            }else if(sum > k){
                sum -= sequence[left];
                left++;
            }else if(sum == k){
                // index 저장
                list.add(new int[] {left, right});
                sum -= sequence[left];
                left++;
            }
        }
        
        Collections.sort(list, (a, b) -> {
            int lenA = a[1] - a[0];
            int lenB = b[1] - b[0];
            
            if(lenA != lenB){
                return Integer.compare(lenA, lenB);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        answer[0] = list.get(0)[0];
        answer[1] = list.get(0)[1];
        
        return answer;
    }
}