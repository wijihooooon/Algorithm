import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int coin[] = new int[N];
		int dp[] = new int[100001];
		
		Arrays.fill(dp, 10001);
		
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			dp[coin[i]] = 1;
		}
		
		for(int i=coin[0]; i<=M; i++) { // 동전 coin[0] +1 ~ M 까지
			if(dp[i] != 1) {
				for(int j=0; j<N; j++) {	// 동전 배열안에서 뺑글뻉글
					if(i-coin[j] > 0) {
						dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
					}
				}
			}
		}
		
		if(dp[M] == 10001) {
			System.out.println(-1);
		}else {
			System.out.println(dp[M]);
		}
		
	}
}