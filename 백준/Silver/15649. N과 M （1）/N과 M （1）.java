import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static boolean[] visited;
	public static int[] temp;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		temp = new int[M];
		
		dfs(0);
	}

	private static void dfs(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			return;
		}
				
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			temp[cnt] = i;
			dfs(cnt+1);
			visited[i] = false;
		}
	}
}
