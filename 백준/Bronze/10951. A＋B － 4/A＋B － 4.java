import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int a;
		int b;
		
		while(true) {
			
			String s = br.readLine();
			
			if(s == null) {
				break;
			}
			
			st = new StringTokenizer(s);
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			System.out.println(a+b);
		}

	}

}
