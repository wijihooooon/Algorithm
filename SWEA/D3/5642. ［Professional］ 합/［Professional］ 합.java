import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int num[] = new int[N];
			int dp[] = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0] = num[0];
			
			int max = Integer.MIN_VALUE;
			
			for(int j=1; j<N; j++) {
				dp[j] = Math.max(dp[j-1] + num[j] , num[j]);
				//max = Math.max(dp[j], max);
			}
			
			for(int j=0; j<N; j++) {
				max = Math.max(dp[j], max);
			}
			
			System.out.println("#" + i + " " + max);
		}
	}

}