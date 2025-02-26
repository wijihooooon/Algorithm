import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			int mid = (N/2)+1;
			
			int ans = 0;
			for(int i=0; i<mid; i++) {
				for(int j=mid-i-1; j<mid+i; j++) {
					ans += map[i][j];
				}
			}

			int j=1;
			
			for(int i=mid; i<N; i++) {
				for(int k=j; k<N-j; k++) {
					ans += map[i][k];
				}
				j++;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
