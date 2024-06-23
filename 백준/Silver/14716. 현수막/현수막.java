import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,M;
	
	public static int map[][];
	public static boolean visited[][];
	
	public static int dx[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	public static int dy[] = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<M; k++) {
				map[j][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0; j<N; j++) {
			for(int k=0; k<M; k++) {
				if(map[j][k] == 1 && !visited[j][k]) {
					bfs(j, k);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int j=0; j<8; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cx < N && cy < M) {
					if(map[cx][cy] == 1 && !visited[cx][cy]) {
						visited[cx][cy] = true;
						q.add(new int[] {cx, cy});
					}
				}
			}
		}
	}

}