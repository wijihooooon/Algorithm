import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str = br.readLine();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] prefixSum = new int[str.length()][26]; 
		
		prefixSum[0][str.charAt(0) - 'a'] = 1;
		
		for(int i=1; i<str.length(); i++) {

			for(int j=0; j<26; j++) {
			
				if(str.charAt(i) == (char) j + 'a') prefixSum[i][j]++;
				
				prefixSum[i][j] += prefixSum[i-1][j];
			}
		}

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			char a = st.nextToken().charAt(0);
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(s == 0) {
				sb.append(prefixSum[e][a - 'a']).append("\n");
			}else {
				sb.append(prefixSum[e][a - 'a'] - prefixSum[s-1][a - 'a']).append("\n");
			}
		}
		System.out.println(sb);
	}

}
