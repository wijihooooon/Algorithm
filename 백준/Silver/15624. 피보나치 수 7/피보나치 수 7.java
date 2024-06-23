import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int[1000001];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int j=2; j<=n; j++) {
			dp[j] = (dp[j-1] + dp[j-2]) % 1000000007;
		}
		
		System.out.println(dp[n]);
	}
}