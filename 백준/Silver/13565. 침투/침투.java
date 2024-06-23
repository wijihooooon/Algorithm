import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static int N, M;
	
	public static int map[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1 ,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) { // map 삽입
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) { // Outer side 만 bfs
			for(int j=0; j<M; j++) {
				if(i == 0 && map[i][j] == 0) {
					bfs(i,j);
				}
			}
		}
		
		for(int i=0; i<M; i++) { // Inner side에 도착하는지 확인
			if(map[N-1][i] == -1) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]>q = new LinkedList<>();
		q.add(new int[] {x, y});
		map[x][y] = -1;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int j=0; j<4; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] == 0) {
						map[cx][cy] = -1;
						q.add(new int[] {cx, cy});
					}
				}
			}
		}
	}

}