import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 입국 심사대 N개
		int M = Integer.parseInt(st.nextToken()); // 상근이와 친구들 M명
		
		int[] time = new int[N];
		int maxVal = 0;
		
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(br.readLine());
			maxVal = Math.max(maxVal, time[i]);
		}
		
		immigration(time, M, maxVal);
	}

	private static void immigration(int[] time, int M, int maxVal) {
		long start = 1;
		long end = (long) maxVal * M;
		long result = 0;
		
		while(start<=end) {
			long mid = start + (end - start) / 2;
			
			if(isPossible(time, M, mid)) {
				result = mid;
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(result);
	}

	private static boolean isPossible(int[] time, int M, long mid) {
		long count = 0;
		
		for(int t : time) {
			count += mid / t;
			if(count>=M) return true;
		}
		return false;
	}
}