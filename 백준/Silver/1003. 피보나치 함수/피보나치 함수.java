import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int j=0; j<N; j++) {
			int n = Integer.parseInt(br.readLine());
			
			int count0[] = new int[n+2];
			int count1[] = new int[n+2];
			
			
			count0[0] = 1;
			count1[0] = 0;
			count0[1] = 0;
			count1[1] = 1;
			
			for(int k=2; k<=n; k++) {
				count0[k] = count0[k-2] + count0[k-1];
				count1[k] = count1[k-2] + count1[k-1];	
			}
			System.out.println(count0[n] + " " + count1[n]);
		}
		
	}
}