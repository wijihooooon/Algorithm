import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int N = Integer.parseInt(br.readLine()); // 좌석 수
		int M = Integer.parseInt(br.readLine()); // 고정석 수
		
		int dp[] = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int j=2; j<=N; j++) {
			dp[j] = dp[j-1] + dp[j-2];
		}
		
		int ans = 1;
		
		int num = 0;
		for(int j=0; j<M; j++) {
			int vip = Integer.parseInt(br.readLine());
			
			ans*= dp[vip - num -1];
			num = vip;
		}
		
		ans *= dp[N-num];
		
		System.out.println(ans);
	}

}