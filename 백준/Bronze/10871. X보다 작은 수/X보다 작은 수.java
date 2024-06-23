import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		for(int j=0; j<N; j++) {
			int A = Integer.parseInt(st.nextToken());
			if(A < X) {
				sb.append(A).append(" ");
			}
		}
		System.out.println(sb);
	}
}