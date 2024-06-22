import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] coin = new int[N];
			int[] dp = new int[10001];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {	// 동전 삽입  list = {x, y, ....}
				coin[j] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());	// 금액 입력
			
// 점화식 dp[i] = dp[i] + dp[i-coin] or i - coin == 0 -> dp[i] = dp[i] + 1;
			
			for(int j=0; j<N; j++) { // 동전기준으로 coin[0] 먼저 기록  
				
				for(int k=coin[0]; k<=M; k++) { // 금액
					if(k > coin[j]) {
						dp[k] = dp[k] + dp[k-coin[j]];
					}else if(k == coin[j] ) {
						dp[k]++; 
					}
				}
			}
			System.out.println(dp[M]);
		}
	}
}