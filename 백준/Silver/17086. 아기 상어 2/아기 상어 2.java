import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	
	public static int map[][];
	public static Queue<int[]> q = new LinkedList<>();
	
	public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상 하 좌 우 상좌 상우 하좌 하우
	public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<M; k++) {
				map[j][k] = Integer.parseInt(st.nextToken());
				if(map[j][k] == 1) {
					q.add(new int[] {j,k});
				}
			}
		}
		
		System.out.println(bfs()-1);
		
	}

	private static int bfs() {
		int x,y;
		int safeDistance = 0;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int j=0; j<8; j++) {
				int cx = x +dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] == 0) {
						map[cx][cy] = map[x][y] + 1;
						safeDistance = Math.max(safeDistance, map[cx][cy]);
						q.add(new int[] {cx, cy});
					}
				}
			}
		}
		return safeDistance;
	}

}