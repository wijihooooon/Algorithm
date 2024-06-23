import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[100001];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;
		
		for(int j=8; j<=N; j++) {
			dp[j] = Math.min(dp[j-7], Math.min(dp[j-5], Math.min(dp[j-2], dp[j-1]))) + 1;
		}
		
		System.out.println(dp[N]);
	}

}