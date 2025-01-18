import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			sb = new StringBuilder();
			sb.append("#").append(i).append(" ");
			
			char s[] = br.readLine().toCharArray();
			
			int count = 0;
			
			for(int j=0; j<s.length; j++) {
				if(s[j] == '1') {
					for(int k=j; k<s.length; k++) {
						if(s[k] == '1') {
							s[k] = '0';
						}else {
							s[k] = '1';
						}
					}
					count++;
				}
			}
			
			
			sb.append(count);
			System.out.println(sb);
		}
	}

}
