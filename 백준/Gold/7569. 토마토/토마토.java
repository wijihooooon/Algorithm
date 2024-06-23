import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, L;
	
	public static int map[][][];
	
	public static int dx[] = {-1, 1, 0, 0, 0, 0}; // 좌 우 앞 뒤 아래 위
	public static int dy[] = {0, 0, -1, 1, 0, 0};
	public static int dz[] = {0, 0, 0, 0, -1, 1};
	
	public static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //y
		N = Integer.parseInt(st.nextToken()); //x
		L = Integer.parseInt(st.nextToken()); //z
		
		map = new int[L][N][M];
		
		q = new LinkedList<>();
		
		for(int i=0; i<L; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) {
						q.add(new int[] {j, k, i});
					}
				}
			}
		}
		
		int ans = bfs();
		
		for(int i=0; i<L; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(ans);
	
	}

	private static int bfs() {
		int x, y, z, count;
		count = 1;
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			z = q.peek()[2];
			q.poll();
			
			for(int i=0; i<6; i++) {
				int cx = x +dx[i];
				int cy = y +dy[i];
				int cz = z +dz[i];
				
				if(cx>=0 && cy>=0 && cz>=0 && cx<N && cy<M && cz<L) {
					if(map[cz][cx][cy] == 0) {
						map[cz][cx][cy] = map[z][x][y] + 1;
						q.add(new int[] {cx, cy, cz});
						count = Math.max(count, map[cz][cx][cy]);
					}
				}
			}
		}
		return count-1;
	}
}