import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	
	public static int map[][];
	public static boolean visited[][];
	
	public static int dx[] = {-1, 1 ,0 ,0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					q.add(new int[] {i, j});
					map[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = -1;
                }
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] == 1 && !visited[cx][cy]) {
						map[cx][cy] = map[x][y] + 1;
						visited[cx][cy] = true;
						q.add(new int[] {cx, cy});
					}
				}
			}
		}
	}

}
