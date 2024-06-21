import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 코인 개수 N, 만들어야할 금액K 입력받기
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int coin[] = new int[N];
		int dp[] = new int[K+1];
		
		// 코인값 배열에 입력받기
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=coin[i]; j<=K; j++) {
				if(j > coin[i]) {
					dp[j] += + dp[j - coin[i]];
				}else {
					dp[j]++;
				}
			}
		}
		System.out.println(dp[K]);
	}

}
