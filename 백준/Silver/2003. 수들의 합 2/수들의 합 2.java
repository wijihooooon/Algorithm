import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] prefixSum = new int[N];
		
		prefixSum[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			prefixSum[i] = arr[i] + prefixSum[i-1];
		}
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			if(prefixSum[i] == M) {
				count++;
				continue;
			}
			for(int j=0; j<i; j++) {
				if(prefixSum[i] - M == prefixSum[j]) {
					count++;
					continue;
				}
			}
		}
		
		System.out.println(count);
	}
}
