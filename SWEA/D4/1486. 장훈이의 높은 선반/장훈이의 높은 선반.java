import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int N, B;
	public static int[] arr;
	public static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ans = Integer.MAX_VALUE;
			dfs(0, 0);
			sb.append("#").append(t).append(" ").append(ans-B).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt, int sum) {
		if(sum>=B) {
			ans = Math.min(ans, sum);
		}
		
		if(cnt == N) return;
		
		dfs(cnt+1, sum+arr[cnt]);
		
		dfs(cnt+1, sum);
	}

}
