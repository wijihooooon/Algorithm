import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for(int j=0; j<s.length(); j++) {
				for(int k=0; k<M; k++) {
					sb.append(s.charAt(j));
				}
			}
			System.out.println(sb);
		}
	}

}
