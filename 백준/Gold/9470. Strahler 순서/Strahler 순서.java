import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			int[] deg = new int[M+1];
			int[] cnt = new int[M+1];
			int[] order = new int[M+1];
			
			ArrayList<Integer>[] graph = new ArrayList[M+1];
			
			for(int i=1; i<=M; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<P; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				deg[b]++;
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			for(int i=1; i<=M; i++) {
				if(deg[i] == 0) {
					q.add(i);
					order[i] = 1;
					cnt[i] = 1;
				}
			}
			
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for(int nxt : graph[now]) {
					if(order[now] > order[nxt]) {
						order[nxt] = order[now];
						cnt[nxt] = 1;
					}else if(order[now] == order[nxt]) {
						cnt[nxt]++;
					}
					
					deg[nxt]--;
					if(deg[nxt] == 0) {
						if(cnt[nxt]>=2) {
							order[nxt]++;
						}
						q.add(nxt);
					}
				}
			}
			sb.append(K).append(" ").append(order[M]).append("\n");
		}
		System.out.println(sb);
	}
}
