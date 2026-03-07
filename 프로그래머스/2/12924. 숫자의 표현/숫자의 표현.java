class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 1;
        int sum = 1;
        
        while(start <= n/2){
            if(sum == n){
                answer++;
                sum -= start;
                start++;
            }else if(sum<n){
                end++;
                sum += end;
            }else if(sum>n){
                sum -= start;
                start++;
            }
        }       
        return answer + 1;
    }
}