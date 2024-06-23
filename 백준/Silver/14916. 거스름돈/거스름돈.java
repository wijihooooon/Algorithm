import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[100001][2];
		dp[0][0] = 0;
		dp[0][1] = 0;
		
		dp[1][0] = 3;
		dp[1][1] = -1;
		
		dp[2][0] = 1;
		dp[2][1] = 0;
		
		dp[3][0] = 4;
		dp[3][1] = -1;
		
		dp[4][0] = 2;
		dp[4][1] = 0;
		
		dp[5][0] = 0;
		dp[5][1] = 1;
		
		dp[6][0] = 3;
		dp[6][1] = 0;
		
		dp[7][0] = 1;
		dp[7][1] = 1;
		
		dp[8][0] = 4;
		dp[8][1] = 0;
		
		dp[9][0] = 2;
		dp[9][1] = 1;
		
		
		for(int j=10; j<=N; j++) {
			dp[j][0] = dp[j-10][0];
			dp[j][1] = dp[j-10][1] + 2;
		}
		
		if(N == 1 || N == 3) {
			System.out.println("-1");
		}else {
			System.out.println(dp[N][0] + dp[N][1]);
		}
	}

}