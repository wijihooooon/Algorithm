import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] map = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		 
		 int left = 0;
		 int count = 0;
		 int ans = Integer.MAX_VALUE;
		 
		 for(int right=0; right<N; right++) {
			 if(map[right] == 1) count ++;
			 
			 while(count >= K) {
				 ans = Math.min(ans, right - left + 1);
				 if(map[left] == 1) count--;
				 left++;
			 }
		 }
		 
		 System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

}
