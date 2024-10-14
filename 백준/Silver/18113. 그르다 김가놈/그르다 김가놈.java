import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, K, max;
	
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0; i<N; i++) { // 김밥 길이 받기
			arr[i] = Integer.parseInt(br.readLine());
			 if(arr[i] >= 2*K) {
				 arr[i] -= 2*K;
			 }else if(arr[i] > K) {
				 arr[i] -= K;
			 }else {
				 arr[i] = 0;
			 }
			 max = Math.max(max, arr[i]);
		}
		
		System.out.println(binarySearch());
		
	}

	private static int binarySearch() {
		int start = 1;
		int end = max;
		int result = 0;
		
		while(start <= end) {
			int mid =(start + end) / 2;
			int sum = 0;
			
			for(int i=0; i<N; i++) {
				sum += arr[i] / mid;
			}
			
			if(sum >= M) {// 최소 개수 만족
				result = mid;
				start = mid + 1;
			}else { // 최소 개수 불만족
				end = mid - 1;
			}
		}
		
		return result == 0? -1:result; //result가 반환 할게 없어 0이면 -1 반환
	}

}
