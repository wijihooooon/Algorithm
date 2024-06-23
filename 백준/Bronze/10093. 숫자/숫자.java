import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		if( A == B) {
			System.out.println("0");
		}else {
			long C = Math.min(A, B);
			long D = Math.max(A, B);
			
			System.out.println(D-C-1);
			
			for(long j=C+1; j<D; j++) {
				System.out.print(j + " ");
			}
		}
		
	}
}