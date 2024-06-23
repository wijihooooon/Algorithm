import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, x1, y1, x2, y2;
	
	public static int map[][];
	
	public static int dx[] = {-2, -2, 0, 0, 2, 2};
	public static int dy[] = {-1, 1, -2, 2, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
			
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
		
	}

	private static int bfs() {
		int x,y;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x1, y1});
		map[x1][y1] = 1;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<6; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<N) {
					if(map[cx][cy] == 0) {
						map[cx][cy] = map[x][y] + 1;
						q.add(new int[] {cx, cy});
					}
				}
				if(cx == x2 && cy == y2) {
					return map[cx][cy] - 1;
				}
			}
		}
		return -1;
	}
}