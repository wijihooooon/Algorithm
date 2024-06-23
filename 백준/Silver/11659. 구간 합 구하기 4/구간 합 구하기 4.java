import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		int dp[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<N; j++) {
			arr[j] = Integer.parseInt(st.nextToken());
			dp[j+1] += dp[j] + arr[j];
		}
		
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[b] - dp[a-1]);
		}
	}
}
