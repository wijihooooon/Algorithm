import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {0, 0, -1, 1}; // 하상좌우
	static int dy[] = {-1, 1, 0, 0};
 	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int j=0; j<N; j++) {
			String s = br.readLine();
			for(int k=0; k<M; k++) {
				map[j][k] = s.charAt(k) - '0';
			}
		}
		
		visited = new boolean[N][M];
		bfs(0,0);
		sb.append(map[N-1][M-1]);
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<spot> q = new LinkedList<>();
		q.add(new spot(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			spot temp = q.poll();
			for(int j=0; j<4; j++) {
				int nextX = temp.x + dx[j];
				int nextY = temp.y + dy[j];
				
				if(nextX<0 || nextY<0 || nextX>=N || nextY>= M) continue;
				if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
				
				q.add(new spot(nextX, nextY));
				visited[nextX][nextY] = true;
				map[nextX][nextY] = map[temp.x][temp.y] + 1;
			}
		}
	}
}

class spot {
	int x;
	int y;
	spot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
