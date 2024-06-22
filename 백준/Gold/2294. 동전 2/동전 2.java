import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 문자열 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine()); // " "기준으로 문자열 나눠주기, new StringTokenizer(br.readLine(), " ")과 같음 뒤에 스킵 가능
		
		int N = Integer.parseInt(st.nextToken()); // 동전 N개
		int K = Integer.parseInt(st.nextToken()); // 금액 K개
		
		int coin[] = new int[N]; // 동전 배열
		int dp[] = new int[K+1]; // dp용 배열
		
		// 동전 입력
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		
		for(int i=0; i<N; i++) { //동전배열
			//if(K >= coin[i]) {
				for(int j=coin[i]; j<=K; j++) { //금액 배열
					dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
				//}
			}
		}
		
		if(dp[K] == 10001) {
			System.out.println(-1);
		}else {
			System.out.println(dp[K]);
		}

	}
}
