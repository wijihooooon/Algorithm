class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int num1 = a;
        int num2 = b;
        if(a>b){
            num1 = b;
            num2 = a;
        }
        
        for(int i=num1; i<=num2; i++){
            answer += i;
        }
        return answer;
    }
}