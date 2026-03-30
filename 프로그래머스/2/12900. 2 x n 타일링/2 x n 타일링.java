import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int dp[] = new int[60001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        
        for(int i=5; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        answer = dp[n];
        return answer;
    }
}