import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
	public static int N;
	
	public static int cheese[][];
	public static boolean visited[][];
	
	public static int dx[] = {-1, 1 ,0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			cheese = new int[N][N];
			visited = new boolean[N][N];
			
			// 치즈 값 넣기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 1;
			
			for(int i=1; i<=100; i++) { // 1~100일
				boolean eat = false;
				int count = 0;
				visited = new boolean[N][N];
				
				for(int j=0; j<N; j++) { // 치즈를 돌아다니며 요정이 먹을 수 있는 치즈가 있는지 탐색
					for(int k=0; k<N; k++) {
						if(cheese[j][k] == i) {
							cheese[j][k] = -1; // 요정이 먹어버린 부분을 -1로 표시
							eat = true;
						}
					}
				}
				
				if(eat) { // 요정이 먹은 부분이 있으면 bfs로 덩이 수 세기
					for(int j=0; j<N; j++) {
						for(int k=0; k<N; k++) {
							if(cheese[j][k] != -1 && !visited[j][k]) {
								check(j, k);
								count++;
							}
						}
					}
					
				}
				ans = Math.max(ans, count);
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void check(int x, int y) {
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
			
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<N) {
					if(!visited[cx][cy] && cheese[cx][cy] != -1) {
						q.add(new int[] {cx, cy});
						visited[cx][cy] = true;
					}
				}
			}
		}
	}
}
