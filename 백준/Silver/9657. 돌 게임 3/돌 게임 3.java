import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String dp[] = new String[1001];
		
		dp[1] = "SK";
		dp[2] = "CY";
		dp[3] = "SK";
		dp[4] = "SK";
		
		for(int j=5; j<=N; j++) {
			if(dp[j-1] == "SK" && dp[j-3] == "SK" && dp[j-4] == "SK") {
				dp[j] = "CY";
			}else {
				dp[j] = "SK";
			}
		}
		System.out.println(dp[N]);
	}
}