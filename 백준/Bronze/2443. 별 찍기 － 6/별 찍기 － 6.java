import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=N; i>0; i--) {
			for(int j=0; j<N-i; j++) {
				System.out.print(" ");
			}
			for(int k=2*i-1; k>0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}