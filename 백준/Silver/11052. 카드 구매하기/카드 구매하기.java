import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int card[] = new int[1001];
		int dp[] = new int[1001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int j=1; j<=N; j++) {
			card[j] = Integer.parseInt(st.nextToken());
		}
		
		for(int j=1; j<=N; j++) {
			for(int k=1; k<=j; k++) {
				dp[j] = Math.max(dp[j], dp[j-k] + card[k]);
			}
		}
		
		System.out.println(dp[N]);
	}

}