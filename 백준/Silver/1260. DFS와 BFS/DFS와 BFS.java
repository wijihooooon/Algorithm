import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
	static int N,M;
	static int map[][];
	static boolean visited[];
	static	StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int j=1; j<=M; j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		visited = new boolean[N+1];
		dfs(start);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs(start);
		
		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			
			start = q.poll();
			sb.append(start + " ");
			for(int j=1; j<=N; j++) {
				if(map[start][j] == 1 && !visited[j]) {
					q.add(j);
					visited[j] = true;
				}
			}
		}
	}

	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start + " ");
		
		for(int j=1; j<=N; j++) {
			if(map[start][j] == 1 && !visited[j]) {
				dfs(j);
			}
			
		}
	}
}