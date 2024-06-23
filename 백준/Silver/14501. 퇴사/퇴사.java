import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int Ti[] = new int[N+1];
		int Pi[] = new int[N+1];
		
		for(int i=1; i<=N; i++) { // 1일 부터 N일 까지 삽입
			st = new StringTokenizer(br.readLine());
			Ti[i] = Integer.parseInt(st.nextToken());
			Pi[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N+2];
		
		
		for(int i=1; i<=N; i++) {
			if(i + Ti[i] <= N+1) {
				dp[i+Ti[i]] = Math.max(dp[i+Ti[i]], dp[i] + Pi[i]);
			}
			dp[i+1] = Math.max(dp[i], dp[i+1]);
			
		}
		
		System.out.println(dp[N+1]);
		
	}

}