import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int l, x1, y1, x2, y2;
	
	public static Queue<int[]> q;;
	
	public static int dx[] = {-2, -2, -1, 1, 2, 2, 1, -1}; // 시계방향~
	public static int dy[] = {-1, 1, 2, 2, 1, -1, -2, -2};
	
	public static int map[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			l = Integer.parseInt(br.readLine());
			
			q = new LinkedList<>();
			
			map = new int[l][l];
			
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			
			q.add(new int[] {x1, y1});
			map[x1][y1] = 1;
			
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			bfs();
			
		}
		
		
	}

	private static void bfs() {
		int x, y;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int j=0; j<8; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cx<l && cy<l) {
					if(map[cx][cy] == 0) {
						map[cx][cy] = map[x][y] + 1;
						q.add(new int[] {cx, cy});
					}
				}
				
				if(cx == x2 && cy == y2) {
					System.out.println(map[x2][y2]-1);
					return;
				}
				
			}
		}
	}
}