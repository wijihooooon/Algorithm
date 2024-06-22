import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N];
		int cost[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j=0; j<N; j++) {
			cost[j] = Integer.parseInt(st.nextToken());
		}

		dp[0] = cost[0];
		for(int j=1; j<N; j++) {
			dp[j] = Math.max(dp[j-1] + cost[j], cost[j]);
		}	
		
		int max = Integer.MIN_VALUE;
		
		for(int j=0; j<N; j++) {
			max = Math.max(dp[j], max);
		}
		
		System.out.println(max);
	}
}
