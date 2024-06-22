import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int triangle[][] = new int[N][N];
		
		int dp[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=N-2; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
			}
		}
		System.out.println(triangle[0][0]);
	}
}