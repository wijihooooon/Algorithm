import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int N = triangle.length;
        int M = triangle.length;
        
        int[][] dp = new int[N][M];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<N; i++){
            for(int j=0; j<=i; j++){
                if(j==0){       // 맨앞
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j==i){ // 맨뒤
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    break;
                }else{          // 중간
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                }
            }
        }
        
        for(int i=0; i<M; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }
        
        return answer;
    }
}