import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static int N;
	
	public static int[][] map;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int count;
		int num;
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			count = 0;
			num = 0;
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int newCount = bfs(i, j);
					
					if((count < newCount) || (count == newCount && num > map[i][j])) {
						count = newCount;
						num = map[i][j];
					}
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(num).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		int cnt = 1;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<N) {
					if(map[cx][cy] == map[x][y] + 1) {
						q.add(new int[] {cx, cy});
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
