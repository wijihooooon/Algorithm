import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char chr[][] = new char[5][15];
		int[] length = new int[5];
		
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			length[i] = s.length();
			for(int j=0; j<s.length(); j++) {
				chr[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(i < length[j] && chr[j][i] != 0) {
					sb.append(chr[j][i]);
				}
			}
		}
		System.out.println(sb);
	}

}
