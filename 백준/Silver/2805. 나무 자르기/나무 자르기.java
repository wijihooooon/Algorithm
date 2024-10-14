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
		int max = 0;
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(binarySerach(arr, M, max));
	}

	private static int binarySerach(int[] arr, int M, int max) {
		int start = 1;
		int end = max;
		int result = 0;
		
		while(start <= end) {
			int mid = start + (end - start) / 2; // 오버플로우 방지
			
			long sum = 0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] >= mid) {
					sum += arr[i] - mid;
				}
			}
			
			if(sum >= M) { // 가져 가야하는 나무 길이 이상 벌목 하는 경우
				result = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		return result;
		
	}

}
