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
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] deg = new int[N+1];
		List<Integer>[] list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int singer = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0; j<singer-1; j++) {
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				deg[b]++;
				a = b;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			if(deg[i] == 0) q.add(i);
		}
		
		int count = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			count++;
			sb.append(cur).append("\n");
			
			for(int nxt : list[cur]) {
				deg[nxt]--;
				if(deg[nxt] == 0) {
					q.add(nxt);
				}
			}
		}
		if(count < N) {
			System.out.println(0);
		}else {
			System.out.println(sb);
		}
		
	}
}
