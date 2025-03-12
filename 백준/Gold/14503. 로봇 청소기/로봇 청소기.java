import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		int[][] map = new int[N][M];
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0 ,-1};
		
		Queue<machine> q = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		q.add(new machine(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(!q.isEmpty()) {
			machine now = q.poll();
			
			int x = now.x;
			int y = now.y;
			int d = now.d;
			
			if(map[x][y] == 0) {
				count++;
				map[x][y] = -1;
			}
			
			boolean check = false;
			for(int i=d-1; i>=d-4; i--) {
				int n = i;
				if(i < 0) {
					n += 4;
				}
				int cx = x + dx[n];
				int cy = y + dy[n];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M && map[cx][cy] != 1) {
					if(map[cx][cy] == 0) {
						q.add(new machine(cx, cy, n));
						check = true;
						break;
					}
				}
			}
			
			if(!check) {
				int cx = x;
				int cy = y;
				switch (d) {
				case 0:
					cx += dx[2];
					cy += dy[2];
					break;
				case 1:
					cx += dx[3];
					cy += dy[3];
					break;
				case 2:
					cx += dx[0];
					cy += dy[0];
					break;
				case 3:
					cx += dx[1];
					cy += dy[1];
					break;
				}
				if(cx>=0 && cy>=0 && cx<N && cy<M && map[cx][cy] != 1) {
					q.add(new machine(cx, cy, d));
				}
			}
		}
		System.out.println(count);
	}

	private static class machine{
		int x;
		int y;
		int d;
		
		machine(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}