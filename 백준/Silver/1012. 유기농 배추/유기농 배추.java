// dfs
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static int N, M, K, count;
	public static int[][] map;
	public static boolean[][] visited;
	
	// 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int j=0; j<K; j++) {
				count = 0;
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				
				map[p1][p2] = 1;
			}
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[j][k] == 1 && !visited[j][k]) {
						dfs(j, k);
						count++;
					}
				}
			}
		System.out.println(count);	
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if(cx >= 0 && cy >= 0 && cx < N && cy < M) {
				if(!visited[cx][cy] && map[cx][cy] == 1)
				dfs(cx, cy);
			}
		}
	}

}