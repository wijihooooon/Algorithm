import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int[] p;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 집의 수
		int N = Integer.parseInt(st.nextToken()); // 간선의 수
		int total = 0;
		
		if(M == 0 && N == 0) break;
		
		Edge[] edge = new Edge[N];
		p = new int[M+1];
		
		Arrays.fill(p, -1);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			total += w;
			edge[i] = new Edge(u, v, w);
		}
		
		Arrays.sort(edge);
		
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			int from = edge[i].from;
			int to = edge[i].to;
			int cost = edge[i].cost;
			
			if(!union(from, to)) continue;
			
			ans += cost;
		}
		
		sb.append(total - ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int find(int x) {
		if(p[x] < 0) return x;
		return p[x] = find(p[x]);
	}
	
	private static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) return false;
		
		if(p[u] < p[v]) {
			p[v] = u;
		}else {
			p[u] = v;
		}
		
		return true;
	}
	
	private static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		
		@Override
		public int compareTo(Edge edge) {
			return Integer.compare(this.cost, edge.cost);
		}
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
