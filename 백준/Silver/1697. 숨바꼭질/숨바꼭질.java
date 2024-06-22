import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, K;
	
	public static int map[] = new int[100001];
	public static boolean visited[] = new boolean[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N > K) {
			System.out.println(N - K);
		}else {
			bfs();
		}
		
		
	}

	private static void bfs() {
		Queue<Integer>q = new LinkedList<>();
		q.add(N);
		visited[N] = true;
		
		while(!q.isEmpty()) {
			int now  = q.poll();
			
			if(now == K) {
				System.out.println(map[K]);
				return;
			}
			
			if(now - 1 > 0 && !visited[now-1]) {
				visited[now - 1] = true;
				map[now - 1] = map[now] + 1;
				q.add(now - 1);
			}
			
			if(now + 1 < 100001 && !visited[now+1]) {
				visited[now + 1] = true;
				map[now + 1] = map[now] + 1;
				q.add(now + 1);
			}
			
			if(now * 2 < 100001 && !visited[now * 2]) {
				visited[now * 2] = true;
				map[now * 2] = map[now] + 1;
				q.add(now * 2);
			}
		}
	}
}
