import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine());
			
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			char[] s1Array = new char[s1.length()];
			char[] s2Array = new char[s2.length()];
			
			for(int k=0; k<s1.length(); k++) {
				s1Array[k] = s1.charAt(k);
			}
			
			for(int k=0; k<s2.length(); k++) {
				s2Array[k] = s2.charAt(k);
			}
			
			Arrays.sort(s1Array);
			Arrays.sort(s2Array);
			if(s1.length() == s2.length()) {
					for(int k=0; k<s1.length(); k++) {
					if(s1Array[k] != s2Array[k]) {
						System.out.println("Impossible");
						break;
					}else if(k == s1.length()-1 && s1Array[k] == s2Array[k]) {
						System.out.println("Possible");
					}
				}
			}else {
				System.out.println("Impossible");
			}
			
		}
	}

}