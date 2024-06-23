import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][K];
		
		for(int l=0; l<2; l++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<K; j++) {
					arr[i][j] += Integer.parseInt(st.nextToken());
				}
			}
		}
		for(int j=0; j<N; j++) {
			for(int k=0; k<K; k++) {
				System.out.print(arr[j][k] + " ");
			}
			System.out.println();
		}
				
	}
}