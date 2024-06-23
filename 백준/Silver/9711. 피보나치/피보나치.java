import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger dp[] = new BigInteger[10001];
		
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.ONE;
		
		for(int k=3; k<10001; k++) {
				dp[k] = dp[k-1].add(dp[k-2]);
			}
		
		for(int j=0; j<N; j++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			System.out.println("Case #" + (j+1) + ": " + dp[P].remainder(BigInteger.valueOf(Q)));
		}
	}
}