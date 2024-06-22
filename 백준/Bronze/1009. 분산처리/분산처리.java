import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int j=0; j<T; j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a %= 100;
			a %= 10;
			int ans = a;
			for(int k=0; k<b-1; k++) {
				ans *= a;
				ans %= 100; 
				ans %= 10;
			}
			if(ans == 0) {
				ans = 10;
			}
			System.out.println(ans);
		}
	}
}