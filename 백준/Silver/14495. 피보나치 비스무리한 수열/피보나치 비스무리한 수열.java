import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long dp[] = new long[117];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int j=4; j<=N; j++) {
			dp[j] = dp[j-1] + dp[j-3];
		}
		System.out.println(dp[N]);
	}
}