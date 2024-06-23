import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double num[] = new double[N];
		
		for(int j=0; j<N; j++) {
			num[j] = Double.parseDouble(br.readLine());
		}
		
		double dp[] = new double[10001];
		
		dp[0] = num[0];
		
		double max = Double.MIN_VALUE;
		
		for(int j=1; j<N; j++) {
			
			dp[j] = Math.max(num[j], num[j] * dp[j-1]);
			max = Math.max(max, dp[j]);
		}
		System.out.printf("%.3f\n", max);
		
	}

}