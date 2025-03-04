import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static Queue<int[]> q;
	public static void main(String[] args)throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		int count = 0;
		int ans = 1;
		
		for(int i=min-1; i<=max; i++) {
			visited = new boolean[N][N];
			count = 0;
			q = new LinkedList<>();
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(!visited[j][k] && map[j][k] > i) {
						q.add(new int[] {j, k});
						visited[j][k] = true;
						bfs(i);
						count++;
					}
				}
			}
			ans = Math.max(count, ans);
		}
		System.out.println(ans);
	}
	private static void bfs(int flower) {
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<N && cy<N) {
					if(!visited[cx][cy] && map[cx][cy] > flower) {
						q.add(new int[] {cx, cy});
						visited[cx][cy] = true;
					}
				}
			}
		}
	}

}
