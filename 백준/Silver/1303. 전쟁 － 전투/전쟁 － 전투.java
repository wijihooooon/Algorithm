import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	
	public static char map[][];
	public static boolean check[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		
		map = new char[N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int wPower = 0;
		int bPower = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!check[i][j]) {
					if(map[i][j] == 'W') {
						wPower += bfs(i, j, 'W');
					}else {
						bPower += bfs(i, j, 'B');
					}
					
				}
			}
		}
		System.out.println(wPower + " " + bPower);
	}

	private static int bfs(int x, int y, char color) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		check[x][y] = true;
		int power = 1;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx >= 0 && cy >= 0 && cx < N && cy < M) {
					if(!check[cx][cy] && map[cx][cy] == color) {
						q.add(new int[] {cx, cy});
						check[cx][cy] = true;
						power++;
					}
				}
			}
		}
		return power * power;
	}

}
