import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] p;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 정점의 수
		int M = Integer.parseInt(br.readLine()); // 간선의수
		
		Node[] edge = new Node[M];
		p = new int[N+1];
		
		Arrays.fill(p, -1);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			edge[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edge);
		
		int ans = 0;
		
		for(int i=0; i<M; i++) {
			int from = edge[i].from;
			int to = edge[i].to;
			int cost = edge[i].cost;
			
			if(!union(from, to)) continue;
			
			ans += cost;
			
		}
		System.out.println(ans);
	}
	
	private static int find(int x) {
		if(p[x] < 0) return x;
		return p[x] = find(p[x]);
	}
	
	private static boolean union(int u, int v) {
		// u v 루트 노드 찾아오기
		u = find(u);
		v = find(v);
		
		// 같으면 같은 집합 이기에 false
		if(u == v) return false;
		
		if(p[u] < p[v]) {
			p[v] = u;
		}else {
			p[u] = v;
		}
		return true;
	}
	
	private static class Node implements Comparable<Node>{
		int from;
		int to;
		int cost;
		
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.cost, node.cost);
		}
		
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
