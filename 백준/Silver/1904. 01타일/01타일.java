import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =Integer.parseInt(br.readLine());
		
		int dp[] = new int[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int j=3; j<=N; j++) {
			dp[j] = (dp[j-1] + dp[j-2]) % 15746;
		}
		
		System.out.println(dp[N]);
	}
}