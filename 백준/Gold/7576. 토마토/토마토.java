import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	
	public static int map[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //y
		N = Integer.parseInt(st.nextToken()); //x
		
		map = new int[N][M];
		
		q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new int[] {i, j});
				}
				
			}
		}
		
		bfs();
		
		int day = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}else {
					day = Math.max(day, map[i][j]);
				}
				
			}
		}
		
		System.out.println(day-1);
		
		
		
	}

	private static void bfs() {
		int x, y;
		
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] == 0 || ((map[cx][cy] != -1 || map[cx][cy] != 1) && map[cx][cy] > map[x][y] + 1)) {
						map[cx][cy] = map[x][y] + 1;
						q.add(new int[] {cx, cy});
					}
				}
			}
		}
	}
}