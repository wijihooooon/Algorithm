import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[];
		int sum;
		
		for(int i=1; i<=N; i++) {
			arr = new int[20];
			
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			for(int j=0; j<20; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			sum = 0;
			
			for (int j = 1; j < 20; j++) {
			    int key = arr[j];
			    int k = j - 1;

			    while (k >= 0 && arr[k] > key) {
			        arr[k + 1] = arr[k];
			        k--;
			        sum++;
			    }
			    arr[k + 1] = key;
			}
			
			System.out.println(i + " " + sum);
			
		}
	}

}
