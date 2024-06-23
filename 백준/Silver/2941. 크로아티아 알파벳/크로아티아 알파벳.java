import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(i<s.length()-1 && (s.substring(i,i+2).equals("c=") || s.substring(i,i+2).equals("c-") || s.substring(i,i+2).equals("d-") || s.substring(i,i+2).equals("lj") || s.substring(i,i+2).equals("nj") || s.substring(i,i+2).equals("s=")
					|| s.substring(i,i+2).equals("z="))) {
				count++;
				i++;
				
			}else if(i<s.length()-2 && s.substring(i,i+3).equals("dz=")) {
				count++;
				i+=2;
				
			}else {
				count++;
			}
		}
		System.out.println(count);
	}

}
