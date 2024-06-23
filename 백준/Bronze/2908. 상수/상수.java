import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		
		String ans = "";
		
		for(int i=2; i>=0; i--) {
			if(s1.charAt(i) > s2.charAt(i)) {
				ans = s1;
				break;
			}else if(s1.charAt(i) < s2.charAt(i)) {
				ans = s2;
				break;
			}
		}
		System.out.println(new StringBuilder(ans).reverse().toString());
	}

}
