import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
class Main {
	
	public static int N, M, size, count;
	
	public static int[][] map;
	public static boolean [][] visited;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = 0;
		size = 0;
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0; j<N; j++) {
			for(int k=0; k<M; k++) {
				if(map[j][k] == 1 && !visited[j][k]) {
					size = Math.max(bfs(j, k), size);
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(size);
		
	}
	public static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] =  true;
		
		int localsize = 1;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int j=0; j<4; j++) {
			int cx = x + dx[j];
			int cy = y + dy[j];
			
				if(cx >= 0 && cy >= 0 && cx < N && cy < M) {
					if(!visited[cx][cy] && map[cx][cy] == 1) {
						visited[cx][cy] = true;
						q.add(new int[] {cx, cy});
						localsize++;
					}
				}
			}
		}
		return localsize;
	}
}