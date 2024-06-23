import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dpA[] = new int[46];
		int dpB[] = new int[46];
		
		dpA[1] = 0;
		dpB[1] = 1;
		dpA[2] = 1;
		dpB[2] = 1;
		dpA[3] = 1;
		dpB[3] = 2;
		
		for(int j=4; j<=N; j++) {
			dpA[j] = dpA[j-1] + dpA[j-2];
			dpB[j] = dpB[j-1] + dpB[j-2];
		}
		
		System.out.println(dpA[N] + " " + dpB[N]);
	}
}