import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N+1];
		
		dp[1] = 1;
		
		if(N > 1) {
			dp[2] = 3;
			for(int j=3; j<=N; j++) {
				dp[j] = (dp[j-1] + 2*dp[j-2]) % 10007;
			}
		}
		
		System.out.println(dp[N]);
		
	}
}