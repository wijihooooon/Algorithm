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
		
		int[] house = new int[N];
		
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}		
		Arrays.sort(house);
		findBestWifiDistance(house, M);
	}

	private static void findBestWifiDistance(int[] house, int M) {
		int start = 1;
		int end = house[house.length-1] - house[0];
		int result = 0;
		
		while(start<=end) {
			int mid = (start + end) / 2;
			
			if(isPossible(house, M, mid)) {
				result = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}

	private static boolean isPossible(int[] house, int M, int mid) {
		int count = 1;
		int last = house[0];
		
		for(int i=1; i<house.length; i++) {
			if(house[i]-last >= mid) {
				count++;
				last = house[i];
			}
		}
		return count >= M;
	}
}