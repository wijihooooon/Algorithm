import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int dp[] = new int[D+1];
		
		for(int i=1; i<=K; i++) {
			for(int j=1; j<=K-i; j++) {
				dp[1] = i;
				dp[2] = j;
				
				for(int k=3; k<=D; k++) {
					dp[k] = dp[k-2] + dp[k-1];
				}
				
				if(dp[D] == K) {
					System.out.println(dp[1]);
					System.out.println(dp[2]);
					return;
				}
			}
		}
	}

}
