import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long arr[] = new long[100];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		arr[4] = 2;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			for(int i=5; i<N; i++) {
				arr[i] = arr[i-2] + arr[i-3];
			}
			
			sb.append("#").append(t).append(" ").append(arr[N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
