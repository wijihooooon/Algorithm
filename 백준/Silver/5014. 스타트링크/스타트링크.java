import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int F, S, G, U, D;
	
	public static int map[];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); // 총 층수
		S = Integer.parseInt(st.nextToken()); // 현재 층
		G = Integer.parseInt(st.nextToken()); // 목표 층
		U = Integer.parseInt(st.nextToken()); // 위로 몇칸
		D = Integer.parseInt(st.nextToken()); // 아래로 몇칸
		
		
		map = new int[F+1];
		visited = new boolean[F+1];
		
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == G) {
				System.out.println(map[G]);
				return;
			}
			
			if(now + U <= F && !visited[now + U]) {
				q.add(now + U);
				visited[now + U] = true;
				map[now + U] = map[now] + 1;
				
			}
			
			if(now - D > 0 && !visited[now - D]) {
				q.add(now - D);
				visited[now - D] = true;
				map[now - D] = map[now] + 1;
				
			}
			
		}
		System.out.println("use the stairs");
		return;
	}
}