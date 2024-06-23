import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cost = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cost -= (Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken()));
		}
		if(cost == 0) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

}
