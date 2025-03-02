import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Long[] d = new Long[N+1];
		int[] test = new int[K];
		
		ArrayList<Node>[] graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
			d[i] = Long.MAX_VALUE;
		}
				
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			test[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int testCity : test) {
			pq.add(new Node(testCity, 0));
			d[testCity] = 0L;
		}
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(d[now.to] < now.cost) continue;
			
			for(Node node : graph[now.to]) {
				if (d[node.to] > d[now.to] + node.cost) {
                    d[node.to] = d[now.to] + node.cost;
                    pq.add(new Node(node.to, d[node.to]));
                }
			}
		}
		
		int ansCity = 0;
        Long ansDis = 0L;
        
        for (int i = 1; i <= N; i++) {
            if (d[i] > ansDis) {
                ansDis = d[i];
                ansCity = i;
            }
        }

        System.out.println(ansCity);
        System.out.println(ansDis);
	}
	
	private static class Node implements Comparable<Node> {
		int to;
		long cost;
		
		@Override
		public int compareTo(Node node) {
			return Long.compare(this.cost, node.cost);
		}
		
		public Node(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
	}

}
