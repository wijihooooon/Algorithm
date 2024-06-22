import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	public static int N,M, count;
	public static int map[][];
	public static boolean check[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		count = 0;
		
		sb.append(dfs(1)-1);
		System.out.println(sb);
	}

	private static int dfs(int start) {
		check[start] = true;
		count++;
		
		for(int i=1; i<=N; i++) {
			if(map[start][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
		return count;
	}
}