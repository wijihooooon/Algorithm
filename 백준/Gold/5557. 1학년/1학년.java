import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long dp[][] = new long[N+1][21];
		int arr[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][arr[1]] = 1;
		
		for(int i=2; i<=N; i++) {
			int num = arr[i];
			for(int j=0; j<=20; j++) {
				if(dp[i-1][j] > 0) {
					if(j+num<=20) {
						dp[i][j+num] += dp[i-1][j];
					}
					if(j-num >= 0) {
						dp[i][j-num] += dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[N-1][arr[N]]);
	}

}
