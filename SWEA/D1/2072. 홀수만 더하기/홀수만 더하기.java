import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String args[]) throws IOException{
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			int ans = 0;
			
			for(int i=0; i<10; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num % 2 == 1) {
					ans+=num;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
