import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	public static boolean visited[];
	public static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
			
		}
		
		int count = 0;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}

	private static void dfs(int x) {
		visited[x] = true;
		
		for(int i=0; i<graph[x].size(); i++) {
			int y = graph[x].get(i);
			if(!visited[y]) dfs(y);
		}
	}

}
