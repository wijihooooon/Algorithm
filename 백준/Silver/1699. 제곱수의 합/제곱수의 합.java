import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[100001];
		
		dp[1] = 1;
		
		for(int i = 2; i<=N; i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j=1; j<=i/2; j++) {
				if(j*j == i) {
					dp[i] = 1;
					break;
				}else {
					dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
				}
			}
		}
		System.out.println(dp[N]);
		
	}
}