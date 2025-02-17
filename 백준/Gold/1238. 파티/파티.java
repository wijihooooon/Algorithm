import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, X;
	
	public static int[] dis;
	public static int[] ans;
	public static ArrayList<Node>[] graph;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		dis = new int[N+1];
		ans = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		
		int maxTime = 0;
		
		for(int i=1; i<=N; i++) {
			// 가는거
			ans[i] += dijkstra(i, X);
			// 오는거
			ans[i] += dijkstra(X, i);
			
			maxTime = Math.max(maxTime, ans[i]);
		}
		
		System.out.println(maxTime);
		
	}
	
	private static int dijkstra(int s, int e) {
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dis[s] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			for(Node node : graph[now.city]) {
				if(dis[node.city] > dis[now.city] + node.cost) {
					dis[node.city] = dis[now.city] + node.cost;
					pq.add(new Node(node.city, dis[node.city]));
				}
			}
		}
		return dis[e];
	}
	
	private static class Node implements Comparable<Node>{
		int city;
		int cost;
		
		@Override
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}
		
		public Node(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}
	}
}
