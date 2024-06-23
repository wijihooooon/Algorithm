import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int D[] = new int[N+1];
		D[0] = 1;
		D[1] = 1;
		
		for(int j = 2; j<=N; j++) {
			D[j] = (D[j-1] + D[j-2]) % 10007;
		}
		System.out.println(D[N]);
	}

}