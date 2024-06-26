import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가 개수
			int M = Integer.parseInt(st.nextToken()); // 비행기 종류
			
            for(int j=0;j<M; j++) {
				br.readLine();
			}
            
			System.out.println(N-1); // 국가 개수 -1 은 최소 비행기 탑승 수
		}
	}

}
