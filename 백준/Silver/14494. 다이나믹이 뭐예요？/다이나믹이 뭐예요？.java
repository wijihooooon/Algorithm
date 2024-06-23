import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long dp[][] = new long[1001][1001];
		dp[1][1] = 1;
		dp[1][2] = 1;
		dp[2][1] = 1;
		dp[2][2] = 3;
		
		for(int j=1; j<=N ; j++) {
			for(int k=1; k<=M; k++) {
				if(((k == 1 || k ==2) && j<3) || (j == 1 || j == 2) && k<3) {
					continue;
				}
				dp[j][k] = dp[j][k-1] + dp[j-1][k] + dp[j-1][k-1];
				dp[j][k] %= 1000000007;
			}
		}
		System.out.println(dp[N][M]);
	}
}