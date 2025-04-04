import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			ArrayList<Integer>[] in = new ArrayList[N+1];
			ArrayList<Integer>[] out = new ArrayList[N+1];
			
			for(int i=1; i<N+1; i++) {
				in[i] = new ArrayList<>();
				out[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());

				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				in[B].add(A);
				out[A].add(B);
			}
			
			int ans = 0;
			
			for(int i=1; i<=N; i++) {
				if(heightOrder(in, i) + heightOrder(out, i) == N-1) ans++;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static int heightOrder(ArrayList<Integer>[] order, int start) {
		int size = 0;
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[order.length];
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<order[now].size(); i++) {
				if(visited[order[now].get(i)]) continue;
				q.add(order[now].get(i));
				visited[order[now].get(i)] = true;
				size++;
			}
		}	
		return size;
	}
}