import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Integer>[]list = new ArrayList[V+1];
			int[] deg = new int[V+1];
			Queue<Integer> q = new ArrayDeque<>();
			
			for(int i=1; i<=V; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				deg[b]++;
			}
			
			for(int i=1; i<=V; i++) {
				if(deg[i] == 0) q.add(i);
			}
			
			sb.append("#").append(t).append(" ");
			while(!q.isEmpty()) {
				int cur = q.poll();
				sb.append(cur).append(" ");
				
				for(int nxt : list[cur]) {
					deg[nxt]--;
					if(deg[nxt] == 0) q.add(nxt);
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
