import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	
	public static int map[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static Queue<int[]> Jq = new LinkedList<>();
	public static Queue<int[]> Fq = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				if(s.charAt(j) == '#') {
					map[i][j] = -3;
				}else if(s.charAt(j) == '.') {
					map[i][j] = -1;
				}else if(s.charAt(j) == 'J') {
					map[i][j] = 0;
					Jq.add(new int[] {i, j});
				}else if(s.charAt(j) == 'F') {
					map[i][j] = 0;
					Fq.add(new int[] {i, j});
				}
			}
		}
		
		if(Jq.peek()[0] == 0 || Jq.peek()[1] == 0 || Jq.peek()[0] == N-1 || Jq.peek()[1] == M-1) {
			System.out.println(1);
			return;
		}
		
		fire_bfs();
		

		int ans = J_bfs();
	
		if(ans == -1) { // 탈출 지점에서 시작하는경우
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(ans);
		}
		
	}
	
	private static void fire_bfs() {
		
		while(!Fq.isEmpty()) {
			int x = Fq.peek()[0];
			int y = Fq.peek()[1];
			Fq.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 & cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] == -1) {
						map[cx][cy] = map[x][y] + 1;
						Fq.add(new int[] {cx, cy});
					}
				}
			}
		}
	}
	
	private static int J_bfs() {
		while(!Jq.isEmpty()) {
			int x = Jq.peek()[0];
			int y = Jq.peek()[1];
			Jq.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 & cy>=0 && cx<N && cy<M) {
					if(map[cx][cy] > map[x][y] + 1 || map[cx][cy] == -1) { // 불이 없는경우 map[cx][cy] == -1
						map[cx][cy] = map[x][y] + 1;
						if(cx == 0 || cx == N-1 || cy == 0 || cy == M-1) {
							return map[cx][cy] + 1;
						}
						Jq.add(new int[] {cx, cy});
					}
				}
			}
		}
		return -1;
	}

}
