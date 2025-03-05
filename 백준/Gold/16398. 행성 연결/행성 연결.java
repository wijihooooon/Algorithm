import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] p;
	
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		
		Node[] edge = new Node[N*(N-1)];
		p = new int[N+1];
		
		int idx = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if(i == j) continue;
				edge[idx++] = (new Node(i, j, cost));
			}
		}
		
		Arrays.sort(edge);
		Arrays.fill(p, -1);
		
		long sum = 0;
		int cnt = 0;
		
		for(int i=0; i<idx; i++) {
			int u = edge[i].from;
			int v = edge[i].to;
			int c = edge[i].cost;
			
			if(!union(u, v)) continue;
			sum += c;
			cnt++;
			
			if(cnt == N-1) break;
		}
		System.out.println(sum);
	}
	
	public static int find(int x) {
		if(p[x] < 0) return x;
		return p[x] = find(p[x]);
	}
	
	public static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u==v) return false;
		
		if(p[u]<p[v]) {
			p[v] = u;
		}else if(p[u] > p[v]){
			p[u] = v;
		}else {
			p[v] = u;
			p[u]--;
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
