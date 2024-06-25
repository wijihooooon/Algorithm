import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N, K;
	public static int arr[]; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		System.out.println(binarySerach());
	}

	private static long binarySerach() {
		long left = 1;
		long right = arr[K-1];
		long ans = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
			for(int i=0; i<K; i++) {
				sum += arr[i] / mid;
			}
			
			if(sum >= N) {
				ans = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return ans;
	}

}
