import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		find(arr);
	}

	private static void find(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		int ans = Integer.MAX_VALUE;
		
		while(start!=end) {
			int sum = arr[start] + arr[end];
			
			if(sum>0) {
				end--;
			}else {
				start++;
			}
			
			if(Math.abs(ans) > Math.abs(sum)) {
				ans = sum;
			}
		}		
		System.out.println(ans);
	}
}