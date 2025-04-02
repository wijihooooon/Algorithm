import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static int N, M, R, C, L, count, time;
	public static Pipe[][] map;
	
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			count = 1;
			time = 1;
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new Pipe[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					switch(Integer.parseInt(st.nextToken())) {
					case 1:
						map[i][j] = new Pipe(true, true, true, true);
						break;
					case 2:
						map[i][j] = new Pipe(false, false, true, true);
						break;
					case 3:
						map[i][j] = new Pipe(true, true, false, false);
						break;
					case 4:
						map[i][j] = new Pipe(true, false, false, true);
						break;
					case 5:
						map[i][j] = new Pipe(true, false, true, false);
						break;
					case 6:
						map[i][j] = new Pipe(false, true, true, false);
						break;
					case 7:
						map[i][j] = new Pipe(false, true, false, true);
						break;
					}				
				}
			}			
			whereIsTheThief();
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void whereIsTheThief() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		q.add(new int[] {R, C});
		visited[R][C] =  true;
		
		int x = R;
		int y = C;
		
		while(!q.isEmpty() && time < L) {
			int size = q.size();
			
			for(int j=0; j<size; j++) {
				x = q.peek()[0];
				y = q.peek()[1];
				q.poll();
				
				for(int i=0; i<4; i++) {
					int cx = x + dx[i];
					int cy = y + dy[i];
					
					if(cx>=0 && cy>=0 && cx<N && cy<M) {
						if(!visited[cx][cy] && map[cx][cy] != null &&
								((i==0 && map[x][y].east && map[cx][cy].west) ||
								(i==1 && map[x][y].west && map[cx][cy].east) ||
								(i==2 && map[x][y].south && map[cx][cy].north) ||
								(i==3 &&map[x][y].north && map[cx][cy].south))) {
							q.add(new int[] {cx, cy});
							visited[cx][cy] = true;
							count++;
						}
					}
				}
			}
			time++;
		}
	}

	private static class Pipe{
		boolean east;
		boolean west;
		boolean south;
		boolean north;
		
		Pipe(boolean east, boolean west, boolean south, boolean north){
			this.east = east;
			this.west = west;
			this.south = south;
			this.north = north;
		}
	}
}