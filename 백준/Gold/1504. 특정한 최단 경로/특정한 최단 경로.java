import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, spot1, spot2;
	
	public static ArrayList<Node>[] graph;
	public static int[] dis;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w)); 
			graph[v].add(new Node(u, w)); 
		}
		
		st = new StringTokenizer(br.readLine());
		
		spot1 = Integer.parseInt(st.nextToken());
		spot2 = Integer.parseInt(st.nextToken());
		
		// start -> spot1 -> spot2 -> end
		
		int route1 = Dijkstra(1, spot1);
        int route2 = Dijkstra(spot1, spot2);
        int route3 = Dijkstra(spot2, N);
        
        // start -> spot2 -> spot1 -> end
        int route4 = Dijkstra(1, spot2);
        int route5 = Dijkstra(spot2, spot1);
        int route6 = Dijkstra(spot1, N);

        int temp1 = (route1 == Integer.MAX_VALUE || route2 == Integer.MAX_VALUE || route3 == Integer.MAX_VALUE)
                ? Integer.MAX_VALUE
                : route1 + route2 + route3;

        int temp2 = (route4 == Integer.MAX_VALUE || route5 == Integer.MAX_VALUE || route6 == Integer.MAX_VALUE)
                ? Integer.MAX_VALUE
                : route4 + route5 + route6;

        int result = Math.min(temp1, temp2);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	private static int Dijkstra(int start, int end) {
		dis = new int[N+1];
		visited = new boolean[N+1];
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dis[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (now.toNode == end) return dis[end];
			
			if(visited[now.toNode]) continue;
			visited[now.toNode] = true;
			
			for(Node node : graph[now.toNode]) {
				if(dis[node.toNode] > dis[now.toNode] + node.cost) {
					dis[node.toNode] = dis[now.toNode] + node.cost;
					pq.add(new Node(node.toNode, dis[node.toNode]));
				}
			}
		}
		return dis[end];
	}
	
	private static class Node implements Comparable<Node>{
		int toNode;
		int cost;
		
		@Override
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}
		
		public Node(int toNode, int cost) {
			 this.toNode = toNode;
			 this.cost = cost;
		}
	}
}
