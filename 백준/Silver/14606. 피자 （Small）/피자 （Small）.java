import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		int dp[] = new int[11];
		
		dp[2] = 1;
		
		for(int j=3; j<=N; j++) {
			int a = j/2;
			int b = j - a;
			dp[j] = (a*b) + dp[a] + dp[b];
		}
		
		System.out.println(dp[N]);
		
	}
}