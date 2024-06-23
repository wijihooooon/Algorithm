import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int[n+1];
		
		
		
		for(int j=2; j<=n; j++) {
			dp[j] = dp[j-1] + 1;
			if(j%2 == 0) {
				dp[j] = Math.min(dp[j], dp[j/2] + 1);
			}
			if(j%3 == 0) {
				dp[j] = Math.min(dp[j], dp[j/3] + 1);
			}
		}
		sb.append(dp[n]).append("\n");
		sb.append(n + " ");
		int k = n;
		
		while(k != 1) {
			int p = k;
			int ans = dp[k-1];
			p--;
			
			if(k%2 == 0 && ans > dp[k/2]) {
				ans = dp[k/2];
				p = k/2;
			}
			
			if(k%3 == 0 && ans > dp[k/3]) {
				ans = dp[k/3];
				p = k/3;
			}
			
			k = p;
			sb.append(p + " ");
		}
		
		System.out.println(sb);
	}

}