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
		
        // 현재 동전보다 금액이 크면 dp[j] = d[j] + dp[j - coin[j]]
        // 작으면 dp[j]++
        // ex 동전은 2 -> 금액 |1|2|3|4|5|6|
        //         가능한 조합 |0|1|1|2|2|3|
        // 금액에서 동전의 금액만큼 뺸 위치에서 +1
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
