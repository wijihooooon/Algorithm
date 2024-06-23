import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[N+1][N+1];
		
		for(int j=1; j<=N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int k=1; k<=N; k++) {
				dp[j][k] = dp[j][k-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			
			for(int k=x1; k<=x2; k++) {
				ans += dp[k][y2] - dp[k][y1-1];
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}