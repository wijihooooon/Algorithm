import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long dp[] = new long[N+1];
		dp[0] = 1;
		
		for(int i=1; i<=N; i++) {
			
			long sum = 0;
			for(int j=0, k=i-1; j<i; j++,k--) {
				sum += dp[j] * dp[k];
			}
			dp[i] = sum;
		}
		
		System.out.println(dp[N]);
	}
}