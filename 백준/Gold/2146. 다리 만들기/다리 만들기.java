import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static Queue<int[]> island = new ArrayDeque<>();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 2;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					numberingIsland(map, i, j, num);
					num++;
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		
		while (!island.isEmpty()) {
		    ans = Math.min(findShortestBridge(N, map, island.poll(), ans), ans);
		}
		
		System.out.println(ans);
	}
	
	private static int findShortestBridge(int N, int[][] map, int[] cur, int ans) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		q.add(new int[] {cur[0], cur[1], 0});
		visited[cur[0]][cur[1]] = true;
		
		int now = map[cur[0]][cur[1]];
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int c = q.peek()[2];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if(cx<0 || cy<0 || cx>=N || cy>=N || visited[cx][cy] || map[cx][cy] == now ) continue;
				if(c >= ans) return Integer.MAX_VALUE;
				
				if(map[cx][cy] == 0) {
					q.add(new int[] {cx, cy, c+1});
					visited[cx][cy] = true;
				} else if(map[cx][cy]>0) {
					return c;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	private static void numberingIsland(int map[][], int x, int y, int num) {
		Queue<int[]> q = new ArrayDeque<>();
		int N = map.length;
		boolean[][] visited = new boolean[N][N];
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		map[x][y] = num;
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx<0 || cy<0 || cx>=N || cy>=N || visited[cx][cy]) continue;
				
				if(map[cx][cy] == 1) {
					map[cx][cy] = num;
					visited[cx][cy] = true;
					q.offer(new int[] {cx, cy});
				} else if(map[cx][cy] == 0) {
					island.offer(new int[] {x, y});
					visited[cx][cy] = true;
				}			
			}
		}
	}
}