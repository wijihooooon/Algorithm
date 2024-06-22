import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long dp[] = new long[N+1];
		dp[1] = 1;
		
		if(N>1) {
			dp[2] = 1;
			for(int j=3; j<=N; j++) {
				dp[j] = dp[j-1] + dp[j-2];
			}
		}
		
		System.out.println(dp[N]);
	}
}