import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		long dp[] = new long[1000001];
		dp[0] = 0;
		dp[1] = 1;
		int n = Math.abs(N);
		
		for(int j=2; j<=n; j++) {
			dp[j] = (dp[j-1] + dp[j-2]) % 1000000000;
		}
		
		if(N>0 ||(N<0 && n%2==1)) {
			sb.append("1").append("\n").append(dp[n]);
		}else if(N<0 && N%2 == 0) {
			sb.append("-1").append("\n").append(dp[n]);
		}else {
			sb.append("0").append("\n").append(dp[n]);
		}
		System.out.println(sb);
	}
}