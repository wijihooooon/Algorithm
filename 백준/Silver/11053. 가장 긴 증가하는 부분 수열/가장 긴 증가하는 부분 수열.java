import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int list[] = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int j=1; j<=n; j++) {
			list[j] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(list[i] > list[j] ) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
}
