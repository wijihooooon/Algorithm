import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int N, K, ans;
	public static int[][] map;
	public static boolean visited[][];
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // map 깊이
			K = Integer.parseInt(st.nextToken()); // 공사 가능한 깊이
			
			map = new int[N][N];
			visited = new boolean[N][N];
			int bongwuri = 0;
			ans = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					bongwuri = Math.max(map[i][j], bongwuri);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] != bongwuri) continue;
					visited[i][j] = true;
					makeHikingTrail(i, j, 1, false);
					visited[i][j] = false;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void makeHikingTrail(int x, int y, int count, boolean check) {
		ans = Math.max(ans, count);
		
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx<0 || cy<0 || cx>=N || cy>=N || visited[cx][cy]) continue;
			
			if(map[x][y] > map[cx][cy]) {
				visited[cx][cy] = true;
				makeHikingTrail(cx, cy, count+1, check);
				visited[cx][cy] = false;
			}else if(!check){
				if(map[x][y]-1 >= map[cx][cy]-K) {
					int num = map[cx][cy];
					map[cx][cy] = map[x][y]-1;
					visited[cx][cy] = true;
					makeHikingTrail(cx, cy, count+1, true);
					map[cx][cy] = num;
					visited[cx][cy] = false;
				}
			}
		}
	}
}