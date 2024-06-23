import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int count[] = new int[26];
		
		for(int j=0; j<S.length(); j++) {
			count[S.charAt(j)-'a']++;
		}
		
		for(int j=0; j<count.length; j++) {
			System.out.print(count[j] + " ");
		}		
		
	}
}