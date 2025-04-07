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
		
		int[] LAN = new int[N];
		
		for(int i=0; i<N; i++) {
			LAN[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(LAN);
		measureTheDistance(LAN, M);
	}

	private static void measureTheDistance(int[] LAN, int M) {
		long start = 1;
		long end = LAN[LAN.length-1];
		long result = 0;
		
		while(start<=end) {
			long mid = start + (end - start) / 2;
			
			if(isPossible(LAN, M, mid)) {
				result = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}

	private static boolean isPossible(int[] LAN, int M, long mid) {
		int count = 0;
		
		for(int dis : LAN) {
			count += dis/mid;
		}
		return count>=M;
	}
}