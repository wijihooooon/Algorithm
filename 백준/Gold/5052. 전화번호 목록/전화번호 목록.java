import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] str = new String[N];
			
			for(int i=0; i<N; i++) {
				str[i] = br.readLine();
			}
			
			Arrays.sort(str);
			
			boolean check = true;
			for(int i=0; i<N-1; i++) {
				if(str[i+1].startsWith(str[i])) {
					check = false;
					break;
				}
			}
			
			if(!check) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
}