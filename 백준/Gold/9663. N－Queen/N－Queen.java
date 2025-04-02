import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int N, count;
	
	private static boolean[] danger1; // 세로
	private static boolean[] danger2; // 우하
	private static boolean[] danger3; // 좌하
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		danger1 = new boolean[30];
		danger2 = new boolean[30];
		danger3 = new boolean[30];
		count = 0;
		dfs(0);
		System.out.println(count);
	}

	private static void dfs(int cnt) {
		if(cnt == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(danger1[i] || danger2[cnt-i+N-1] || danger3[i+cnt]) continue;
			
			danger1[i] = true;
			danger2[cnt-i+N-1] = true;
			danger3[i+cnt] = true;
			dfs(cnt+1);
			danger1[i] = false;
			danger2[cnt-i+N-1] = false;
			danger3[i+cnt] = false;			
		}
	}
}