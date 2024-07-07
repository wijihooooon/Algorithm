import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, minS, minE;
	public static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		binarySerach();
		
		System.out.println(minS + " " + minE);
	}

	private static void binarySerach() {
		int start = 0;
		int end = N-1;
		int min = Integer.MAX_VALUE;

		
		while(start < end) {
			int sum = arr[start] + arr[end];
			
			if(Math.abs(min) >= Math.abs(sum)) {
				minS = arr[start];
				minE = arr[end];
				min = sum;
			}
			
			// 이게 핵심
			if(sum > 0) {
				end--;
			}else {
				start++;
			}
		}
	}

}
