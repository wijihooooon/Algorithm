import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int arr[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			binarySearch(Integer.parseInt(st.nextToken()));
		}
		
	}

	private static void binarySearch(int key) {
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			
			int mid = (left + right) / 2; // 중간 값
			
			if(key < arr[mid]) { // 중간 값 보다 작은 경우
				right = mid - 1;
			}else if(key > arr[mid]) { // 중간 값 보다 큰 경우
				left = mid + 1;
			}else { // 중간 값과 같은 경우
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

}