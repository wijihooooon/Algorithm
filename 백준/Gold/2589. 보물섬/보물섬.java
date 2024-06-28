import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, max;
	
	public static int map[][];
	public static boolean visited[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0 ,-1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) { // 물이면 -1 땅이면 0 으로 삽입
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				if(s.charAt(j) == 'W') {
					map[i][j] = -1;
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != -1) {
					visited = new boolean[N][M]; // 할떄마다 매번 초기화 모든 섬에서 bfs()
					bfs(i, j);
				}
			}
		}		
		System.out.println(max);
	}

	private static int bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a, b});
		
		map[a][b] = 0;
		visited[a][b] = true;
		
		while(!q.isEmpty()){
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] != -1 && !visited[cx][cy]) {
						q.add(new int[] {cx, cy});
						visited[cx][cy] = true;
						map[cx][cy] = map[x][y] + 1;
						max = Math.max(max, map[cx][cy]);
					}
				}
			}
		}
		return max;
	}

}
