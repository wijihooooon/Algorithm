import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MAX = 100001;
		int[] dist = new int[MAX];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		Arrays.fill(dist, -1);
		q.offer(N);
		dist[N] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now*2 < MAX &&dist[now*2]==-1) {
				dist[now*2] = dist[now];
				q.offerFirst(now*2);
			}
			
			if(now-1 >= 0 && dist[now-1] == -1) {
				dist[now-1] = dist[now] + 1;
				q.offerLast(now - 1);
			}
			
			if(now+1<MAX && dist[now+1]==-1) {
				dist[now+1] = dist[now]+1;
				q.offerLast(now+1);
			}
		}
		System.out.println(dist[K]);
	}
}