import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[51];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int j=2; j<=N; j++) {
			dp[j] = 1 + dp[j-2] + dp[j-1];
			dp[j] %= 1000000007;
		}
		System.out.println(dp[N]);
	}
}