import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			int sum = 0;
			int cnt = 0;
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == 'O') {
					cnt++;
					sum += cnt;
				}else {
					cnt = 0;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
