import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int count = 0;
		
		int board[][] = new int[101][101];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int j = A; j<A+10; j++) {
				for(int k=B; k<B+10; k++) {
					if(board[j][k] == 0) {
						count++;
						board[j][k]++;
					}
				}
			}
		}
		System.out.println(count);
	}

}