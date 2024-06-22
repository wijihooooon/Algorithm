import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Y = 0;
		int M = 0;
		
		for(int j=0; j<N; j++) {
			int time = Integer.parseInt(st.nextToken());
			Y += (time / 30 + 1) * 10;
			M += (time / 60 + 1) * 15;
		}
		
		if(Y > M) {
			System.out.println("M " + M);
		}else if(Y < M) {
			System.out.println("Y " + Y);
		}else {
			System.out.println("Y M " + Y);
		}
	}
}