import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	public static int grid[][];
	public static boolean visited[][];
	public static int dirX[] = {0, 0, -1, 1}; // 상 하 좌 우
	public static int dirY[] = {1, -1, 0, 0} ;
	public static int N;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		grid = new int[N+1][N+1];
		
		int maxHeight = 0;
		for(int i=1; i<=N; i++) {	// 격자판에 침수지역 삽입
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] >maxHeight) {
					maxHeight = grid[i][j];
				}
			}
		}
		
		int max = 0;
		for(int height=0; height<=maxHeight; height++) {
			visited = new boolean[N+1][N+1];
			int count = 0;
			for(int y=1; y<=N; y++) {
				for(int x=1; x<=N; x++) {
					if(!visited[y][x] && grid[y][x] > height) {
						count += DFS(x, y, height); 
					}
				}
			}
			max = Math.max(max, count);
		}
		
		sb.append(max);
		System.out.println(sb);		
		
	}
	private static int DFS(int x, int y, int height) {
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dirX[i];
			int ny = y + dirY[i];
			
			if(nx>N || ny>N || nx<1 || ny<1) continue;
			if(visited[ny][nx]) continue;
			if(grid[ny][nx] > height) {
				DFS(nx, ny, height);
			}
		}
		return 1;
	}
}