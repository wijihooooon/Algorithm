import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] deg = new int[N+1];
		int[] cost = new int[N+1];
		int[] sum = new int[N+1];
		
		List<Integer>[] list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			cost[i] = t;
			while(true){
				int a =  Integer.parseInt(st.nextToken());
				if(a == -1) break;
				list[a].add(i); 
				deg[i]++;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			if(deg[i] == 0) {
				sum[i] = cost[i];
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int nxt : list[cur]) {
				deg[nxt]--;
				sum[nxt] = Math.max(sum[nxt], sum[cur] + cost[nxt]);
				
				if(deg[nxt] == 0) {
					q.add(nxt);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			sb.append(sum[i]).append("\n");
		}
		System.out.println(sb);
	}
}
