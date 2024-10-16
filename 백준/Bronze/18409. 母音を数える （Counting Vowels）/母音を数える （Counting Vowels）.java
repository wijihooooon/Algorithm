import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'i' || s.charAt(i) == 'u' || s.charAt(i) == 'e' || s.charAt(i) == 'o') {
				count++;
			}
		}
		System.out.println(count);
	}

}
