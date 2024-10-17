import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		for(char c : s.toCharArray()) {
			if(Character.isLowerCase(c)) {
				sb.append(Character.toUpperCase(c));
			}else {
				sb.append(Character.toLowerCase(c));
			}
		}
		System.out.println(sb);
	}

}
