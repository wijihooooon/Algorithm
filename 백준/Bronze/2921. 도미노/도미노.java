import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		for(int i=1; i<=N; i++) {
			ans += (i+1)*i;
			for(int j=i; j>=1; j--) {
				ans+=j;
			}
		}
		System.out.println(ans);
	}
}
