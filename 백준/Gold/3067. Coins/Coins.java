import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			int dp[] = new int[10001];
			int coin[] = new int[num];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<num; j++) {
				coin[j] = Integer.parseInt(st.nextToken());
			}
			
			int money = Integer.parseInt(br.readLine());
			
			for(int j=0; j<num; j++) {
				for(int k=coin[0]; k<=money; k++) {
					if(k > coin[j]) {
						dp[k] = dp[k] + dp[k-coin[j]];
					}else if(k == coin[j]) {
						dp[k]++;
					}
				}
			}
			
			System.out.println(dp[money]);
		}
	}
}