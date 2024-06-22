import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// i 번째 와인을 마시는경우
// i 번째 와인을 마시고 i-1번째 와인을 마시지 않는 경우
// i 번째 와인을 마시고 i-1번째 와인을 마시는 경우
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[10001];
		
		int wine[] = new int[10001];

		for(int j=1; j<=N; j++) {
			wine[j] = Integer.parseInt(br.readLine());
		}
		
	
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];
		
		for(int j=3; j<=N; j++) {
			dp[j] = Math.max(dp[j-1], Math.max(dp[j-2] + wine[j], dp[j-3] + wine[j-1] + wine[j]));
		}
		
		System.out.println(dp[N]);
	}

}