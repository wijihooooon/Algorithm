import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static int V, E;
	public static int[] parent;
	public static PriorityQueue<Edge> q;
	public static int[] rank;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		long ans = 0;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			parent = new int[V+1];
			rank = new int[V+1];
			q = new PriorityQueue<>();
			
			for(int i=1; i<=V; i++) {
				parent[i] = i;
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				q.offer(new Edge(from, to, cost));
			}
			
			ans = 0;
			while(!q.isEmpty()) {
				Edge now = q.poll();
				
				if(find(now.from) != find(now.to)) {
					union(now.from, now.to);
					ans += now.cost;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx == ny) return;
		
		if(rank[nx] < rank[ny]) {
			parent[nx] = ny;
		}else if(rank[ny] < rank[nx]) {
			parent[ny] = nx;
		}else {
			parent[ny] = nx;
		    rank[nx]++;
		}
		
	}

	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.cost, e.cost);
		}
		
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}