import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 설탕은 5, 3 두가지
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[5001];
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;
		
		for(int j=6; j<=N; j++) {
			if(dp[j-3] == -1 && dp[j-5] == -1) {
				dp[j] = -1;
			}else if(dp[j-3] == -1) {
				dp[j] = dp[j-5] + 1;
			}else if(dp[j-5] == -1) {
				dp[j] = dp[j-3] + 1;
			}else {
				dp[j] = Math.min(dp[j-3], dp[j-5]) + 1;
			}
		}
		
		System.out.println(dp[N]);
	}

}