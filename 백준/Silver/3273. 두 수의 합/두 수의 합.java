import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int X = Integer.parseInt(br.readLine());
		
		int start = 0;
		int end = N-1;
		int count = 0;
		int sum = 0;
		
		while(start < end){
			sum = arr[start] + arr[end];
			if(sum == X) {
				count++;
			}
			
			if(sum <= X) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(count);
	}

}
