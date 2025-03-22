import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] L = new int[N + 1]; // 체력
        int[] J = new int[N + 1]; // 기쁨

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][101];

        for(int i=1; i<=N; i++){
            for(int j=1; j<100; j++){
                if(L[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]] + J[i]); // 체력이 가능한경우 전에꺼랑
                }else{
                    dp[i][j] = dp[i-1][j]; // 선택하지 않는 경우 전에 꺼
                }
            }
        }
        int max = 0;
        for (int j = 1; j < 100; j++) {
            max = Math.max(max, dp[N][j]);
        }
        System.out.println(max);

    }
}
/*
풀이 아이디어
dp로 풀기
dp[i][j]
i = 사람
j = 체력
dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]]+J[i]);
dp[i][j] = dp[i-1][j];
 */