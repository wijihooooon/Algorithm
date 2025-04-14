import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] gem = new int[M];
		
		for(int i=0; i<M; i++) {
			gem[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(gem);
		
		int ans = findBestWay(gem, N);
		System.out.println(ans);
		
	}

	private static int findBestWay(int[] gem, int N) {
		int start = 1;
		int end = gem[gem.length-1];
		int ans = Integer.MAX_VALUE;
		
		while(start<=end) {
			int mid = (start + end) / 2;
			int sum = 0;
			
			for(int i=0; i<gem.length; i++) {
				sum += (gem[i] + mid - 1) / mid;
			}
			
			if(sum <= N) {
				ans = Math.min(ans, mid);
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return ans;
	}
}