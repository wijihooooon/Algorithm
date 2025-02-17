import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] graph = new ArrayList[N+1];
		int[] dis = new int[N+1];
		int[] prev = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
			dis[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		dis[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(dis[now.city] < now.cost) continue;
			
			for(Node node : graph[now.city]) {
				if(dis[node.city] > dis[now.city] + node.cost || dis[node.city] == dis[now.city] + node.cost && now.city < prev[node.city]) {
					dis[node.city] = dis[now.city] + node.cost;
					prev[node.city] = now.city;
					pq.add(new Node(node.city, dis[node.city]));
				}
			}
		}
		System.out.println(dis[end]);
		
		List<Integer> path = new ArrayList<>();
		
		for(int i=end; i!=-1; i = prev[i]) {
			path.add(i);
		}
		Collections.reverse(path);
		
		System.out.println(path.size());
		
		for(int i : path) {
			System.out.print(i + " ");
		}
	}
	private static class Node implements Comparable<Node>{
		int city;
		int cost;
		
		@Override
		public int compareTo(Node node) {
			if (this.cost != node.cost) {
                return this.cost - node.cost;
            }
            return this.city - node.city;
		}
		
		public Node(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}
	}
}
