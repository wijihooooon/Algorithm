import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	
	public static int fire_Map[][];
	public static int JH_Map[][];
	
	public static Queue<int[]> fire_Q = new LinkedList<>();
	public static Queue<int[]> JH_Q = new LinkedList<>();
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		fire_Map = new int[N][M];
		JH_Map = new int[N][M];
		
		for(int j=0; j<N; j++) { // 삽입~
			String s = br.readLine();
			for(int k=0; k<M; k++) {
				if(s.charAt(k) == '#') {
					fire_Map[j][k] = -1;
					JH_Map[j][k] = -1;
				}else if(s.charAt(k) == 'J') {
					JH_Q.add(new int[] {j,k});
					JH_Map[j][k] = 1;
				}else if(s.charAt(k) == 'F') {
					fire_Q.add(new int[] {j,k});
					fire_Map[j][k] = 1;
				}
			}
		}
		
		int x, y;
		
		// bfs 불 시작~
			
		while(!fire_Q.isEmpty()) {
			x = fire_Q.peek()[0];
			y = fire_Q.peek()[1];
			fire_Q.poll();
			
			for(int j=0; j<4; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(fire_Map[cx][cy] == 0) {
						fire_Map[cx][cy] = fire_Map[x][y] + 1;
						fire_Q.add(new int[] {cx, cy});
					}
				}
			}
		}
		
		// bfs 지훈이 시작~
		
		while(!JH_Q.isEmpty()) {
			x = JH_Q.peek()[0];
			y = JH_Q.peek()[1];
			JH_Q.poll();
			
			if(x == 0 || x == N-1 || y == 0 || y == M-1) { // 이미 탈출 지점에 있는경우
				System.out.println(JH_Map[x][y]);
				return;
			}
			
			for(int j=0; j<4; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(JH_Map[cx][cy] == 0 && (JH_Map[x][y]+1 < fire_Map[cx][cy] || fire_Map[cx][cy] == 0)) { // || fire_Map[cx][cy] == 0 불이 안간 곳
						JH_Map[cx][cy] = JH_Map[x][y] + 1;
						JH_Q.add(new int[] {cx, cy});
						
						if(cx == 0 || cx == N-1 || cy == 0 || cy == M-1) {
							System.out.println(JH_Map[cx][cy]);
							return;
						}
					}
				}
			}
		}	
		System.out.println("IMPOSSIBLE ");	
	}
}