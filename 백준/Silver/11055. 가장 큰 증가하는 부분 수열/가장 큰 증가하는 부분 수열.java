import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int list[] = new int[N+1];
		int dp[] = new int[N+1];
		
		for(int j=1; j<=N; j++) {
			list[j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(list[i] > list[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = list[i] + max;
		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N]);
	}
}