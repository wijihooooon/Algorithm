import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();
	
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
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(upperBound(key) - lowerBound(key)).append(" ");
		}
		
		System.out.println(sb);
		
	}

	private static int lowerBound(int key) {
		int left = 0;
		int right = N;
		
		while(left < right) {
			
			int mid = (left + right)/2;
			
			if(key <= arr[mid]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return left;
	}

	private static int upperBound(int key) {
		int left = 0;
		int right = N;
		
		while(left < right) {
			
			int mid = (left + right) / 2;
			
			if(key < arr[mid]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return right;
	}



}
