import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i=2; i<=N; i++) {
			arr[i] = i; // 최대값
			
			for(int j=1; j * j <= i; j++) { // 모든 경우중 최소가 되는 경우 ex)12 -> 9 + 1 + 1 + 1, 4 + 4 + 4
				arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
			}
		}
		
		System.out.println(arr[N]);
	}

}
