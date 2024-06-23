import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int mod = 1000000000;
		
		long dp[][] = new long[N+1][10];
		Arrays.fill(dp[1], 1);
		dp[0][9] = 0;
		
		long sum = 10;
		
		for(int j=2; j<=N; j++) {
			sum = 0;
			for(int k=0; k<10; k++) {
				if(k == 0) {
					dp[j][k] = dp[j-1][k+1];
				}else if(k == 9) {
					dp[j][k] = dp[j-1][k-1];
				}else {
					dp[j][k] = (dp[j-1][k-1] + dp[j-1][k+1]) % mod;
				}
				sum += dp[j][k];
			}
		}
		sum -= dp[N][0];
		
		System.out.println(sum % mod);
	}

}